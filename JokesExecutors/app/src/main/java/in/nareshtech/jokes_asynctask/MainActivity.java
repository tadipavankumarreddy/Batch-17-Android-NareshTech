package in.nareshtech.jokes_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    public void getJoke(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        /*new FetchJoke(mProgressBar,mTextView).execute("https://api.chucknorris.io/jokes/random");*/
        Executor e = Executors.newSingleThreadExecutor();

        e.execute(new Runnable() {
            @Override
            public void run() {
                // What ever the background operation that needs to be done, will be done here
                // this works as doInBackground
                StringBuilder sb = new StringBuilder();
                String link = "https://api.chucknorris.io/jokes/random";
                try {
                    URL url = new URL(link);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line = "";
                    while((line=br.readLine())!=null){
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // this runs on Main Thread
                // this works as onPostExecute(...)
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        try {
                            JSONObject obj = new JSONObject(sb.toString());
                            String joke = obj.getString("value");
                            mTextView.setText(joke);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}