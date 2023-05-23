package in.nareshtech.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    public static final String ACTION_CUSTOM = "in.nareshtech.powerreceiver.CUSTOM_RECEIVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        // whatever the broadcasts you are interested in, give them to a IntentFilter Object
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(ACTION_CUSTOM);
        // Registration for Broadcasts
        registerReceiver(new PowerReceiver(imageView),filter);
    }

    //TODO: Create a BroadcastReceiver
    // TODO : Register for certain broadcasts of your interest.
    // TODO: Not to forget to unregister your receiver - usually that happens on onDestroy(...) (not mandatory to do it in onDestroy(..))


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new PowerReceiver(imageView));
    }

    public void sendCustomBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_CUSTOM);
        sendBroadcast(intent);
    }
}