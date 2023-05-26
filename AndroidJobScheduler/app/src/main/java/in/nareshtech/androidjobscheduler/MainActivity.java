package in.nareshtech.androidjobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyReceiver receiver;
    JobScheduler scheduler;
    JobInfo info;

    public static final String DATA_READY_BROADCAST = "someuniquestringhere";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        textView = findViewById(R.id.textView);

        info = new JobInfo.Builder(123,new ComponentName(this, MyJobService.class.getName()))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();

        IntentFilter filter = new IntentFilter(DATA_READY_BROADCAST);
        receiver = new MyReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                String data = intent.getStringExtra("DATA");
                updateData(data);
            }
        };

        registerReceiver(receiver,filter);

    }

    private void updateData(String data) {
        textView.setText(data);
    }

    public void scheduleJob(View view) {
        scheduler.schedule(info);
    }

    // TODO: Create a Jobservice class and define the task that you want to do
    // TODO: Register your service in the manifest file
    // TODO: Define JobInfo and then JobScheduler
    // TODO: Schedule the job
}