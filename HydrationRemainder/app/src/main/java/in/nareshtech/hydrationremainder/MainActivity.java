package in.nareshtech.hydrationremainder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    AlarmManager manager;
    PendingIntent pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }

    public void startRemainder(View view) {
        pi = PendingIntent.getBroadcast(this,124,
                        new Intent(this,HydrationReceiver.class),
                        PendingIntent.FLAG_IMMUTABLE);

        // How to Trigger an Alarm ?
        long triggerTime = SystemClock.elapsedRealtime() + 60*1000 ;
        long intervalTime = 2*60*1000;

        // This method triggers the alarm
        manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,triggerTime,intervalTime,pi);
        Snackbar.make(view,"Alarm Triggered",Snackbar.LENGTH_LONG).show();
    }

    public void stopRemainder(View view) {
        manager.cancel(pi);
        Snackbar.make(view,"Alarm Stopped",Snackbar.LENGTH_LONG).show();
    }
}