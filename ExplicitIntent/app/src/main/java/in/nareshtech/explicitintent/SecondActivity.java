package in.nareshtech.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.result);

        // We should get data out of the intent Object
        Intent intent = getIntent();
        // You can get the using the key
        String d = intent.getStringExtra("DATA");
        // show it to the user
        result.setText(d);
    }
}