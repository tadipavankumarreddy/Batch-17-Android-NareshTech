package in.nareshtech.androidjobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MyJobService extends JobService {

   private JobParameters jobParameters;

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter(MainActivity.DATA_READY_BROADCAST);
        registerReceiver(new MyReceiver(),filter);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        this.jobParameters = params;
        fetchDataFromServer(); // let's say this method handles our background task
        Toast.makeText(this, "Job Is Running", Toast.LENGTH_SHORT).show();
        return true;
    }

    private void fetchDataFromServer() {

        StringBuilder sb = new StringBuilder();
        Executor e = Executors.newSingleThreadExecutor();
        e.execute(new Runnable() {
            @Override
            public void run() {
                // This method actually works in the background
                try {
                    URL url = new URL("https://api.chucknorris.io/jokes/random");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = "";
                    while((line = br.readLine())!=null){
                        sb.append(line);
                    }
                    Log.v("MAIN",sb.toString());
                    jobFinished(jobParameters,false);

                    // Throw a custom broadcast
                    Intent i = new Intent(MainActivity.DATA_READY_BROADCAST);
                    i.putExtra("DATA",sb.toString());
                    sendBroadcast(i);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
