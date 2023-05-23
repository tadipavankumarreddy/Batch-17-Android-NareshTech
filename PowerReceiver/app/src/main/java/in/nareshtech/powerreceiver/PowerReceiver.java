package in.nareshtech.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    private ImageView imageView;

    public PowerReceiver(ImageView imageView) {
        this.imageView = imageView;
    }

    // When ever there is a broadcast of your interest arrives in the system, this `onReceive(...)` is invoked.
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
            // you perform something
            imageView.setImageResource(R.drawable.baseline_battery_charging_full_24);
        }else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
            // you perform some other thing
            imageView.setImageResource(R.drawable.baseline_battery_alert_24);
        }else{
            Toast.makeText(context, "CUSTOM BROADCAST RECEIVED", Toast.LENGTH_SHORT).show();
        }
    }
}