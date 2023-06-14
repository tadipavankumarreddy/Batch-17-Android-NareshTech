package in.nareshtech.multipleflavors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityPaid extends AppCompatActivity {

    EditText roEt;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paid);

        roEt = findViewById(R.id.editTextText);
        b = findViewById(R.id.button);
        
        b.setOnClickListener(v->{
            Toast.makeText(this, "Happy ?!", Toast.LENGTH_SHORT).show();
        });
    }
}