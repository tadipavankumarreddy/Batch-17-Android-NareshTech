package in.nareshtech.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.web_link);
        editText2 = findViewById(R.id.map_address);
    }

    public void openBrowser(View view) {
        String link = editText.getText().toString();
        if(link.isEmpty()){
            editText.setError("Please enter some data to proceed");
        }else{
            Uri u = Uri.parse("https://"+link);
            Intent i = new Intent(Intent.ACTION_VIEW, u);
            startActivity(i);
        }
    }

    public void openMaps(View view) {
        String address = editText2.getText().toString();
        if(address.isEmpty()){
            editText2.setError("Enter your address");
        }else{
            Uri u = Uri.parse("geo:0,0?q="+address);
            Intent i = new Intent(Intent.ACTION_VIEW,u);
            startActivity(i);
        }
    }

    public void openWifiSettings(View view) {
        Intent i = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(i);
    }
}