package in.nareshtech.androidjobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobService extends JobService {

    // We define our task here -> False will be returned when the job is done
    // -> true will be returned when the task is offloaded to a worker thread
    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this, "Task completed", Toast.LENGTH_SHORT).show();
        return false;
    }

    // We write how to stop the task here
    // false -> if there is no need of rescheduling a task
    // true -> when there is a need to reschedule the task
    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
