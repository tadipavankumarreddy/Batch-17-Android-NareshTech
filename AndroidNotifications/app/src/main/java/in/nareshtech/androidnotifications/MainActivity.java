package in.nareshtech.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // To Manage the notification, we need NotificationManager
    NotificationManager manager;

    /* For all the versions that are above or equal to android Oreo (API 26), we require NotificationChannel
     Notificaiton Channels gives the power to the user as it lets the user to choose if he/she wants to see
     the notification from a certain channel or not.*/
    NotificationChannel channel;

    // For the notification channel, we require channel Id and  channel Name
    String channelId = "mychannelId";

    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // notification manager is a system service, so get the service using getSystemService(...) method
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification Channel is only for the devices that run android 8.0 and above
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // this condition becomes true for all the devices that run 8.0 and above
            channel = new NotificationChannel(channelId,"My Noti Channel", NotificationManager.IMPORTANCE_HIGH);
            // To create the channel use manager object
            manager.createNotificationChannel(channel);
        }

    }

    public void sendNotification(View view) {

        PendingIntent pi = PendingIntent.getActivity(this,123,
                new Intent(this,MainActivity.class),PendingIntent.FLAG_IMMUTABLE);

        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.imagetoshow);

        notification = new NotificationCompat.Builder(this,channelId)
                .setSmallIcon(R.drawable.baseline_favorite_24)
                .setContentTitle("Do you like this app ?")
                .setContentText("If you like it, upgrade to pro")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .addAction(R.drawable.baseline_favorite_24,"ACTION 1",pi)
                .addAction(R.drawable.baseline_favorite_24,"ACTION 2",pi)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b))
                .build();

        // to send a notification, use manager.notify(...)
        manager.notify(42,notification);
    }

    public void cancelNotification(View view) {
        manager.cancel(42);
    }
}