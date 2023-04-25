package in.nareshtech.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.data_to_next);
    }

    public void goToNext(View view) {
        String d = editText.getText().toString();
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("DATA",d);
        startActivity(i);
    }
}