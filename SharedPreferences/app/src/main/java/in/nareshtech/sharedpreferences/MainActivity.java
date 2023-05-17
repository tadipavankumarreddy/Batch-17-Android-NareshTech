package in.nareshtech.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.et_name);
        person_age = findViewById(R.id.et_age);
        result = findViewById(R.id.result);
        
        // TODO: Initialize or create shared preferences file
        preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);
    }

    public void saveData(View view) {
        // TODO: Save the data into the shared preferences file
        String name = person_name.getText().toString();
        int age = Integer.parseInt(person_age.getText().toString());
        
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME",name);
        editor.putInt("AGE",age);
        editor.apply();
        
        person_name.getText().clear();
        person_age.getText().clear();

        Toast.makeText(this, "Data successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        // TODO: load the data from the shared preferences file
        result.setText("");
        if(preferences!=null){
            String name = preferences.getString("NAME","Not found");
            int age = preferences.getInt("AGE",0);
            result.setText(name+"\n"+age);
        }
    }
}