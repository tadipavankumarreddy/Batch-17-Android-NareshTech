package in.nareshtech.androidjobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;
    JobInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        info = new JobInfo.Builder(123,new ComponentName(this, MyJobService.class.getName()))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();
    }

    public void scheduleJob(View view) {
        scheduler.schedule(info);
    }

    // TODO: Create a Jobservice class and define the task that you want to do
    // TODO: Register your service in the manifest file
    // TODO: Define JobInfo and then JobScheduler
    // TODO: Schedule the job
}