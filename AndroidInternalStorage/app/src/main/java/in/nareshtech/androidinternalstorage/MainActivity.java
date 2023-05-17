package in.nareshtech.androidinternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText person_name, person_age;
    private TextView result;

    private static final String FILE_NAME = "internal_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.et_name);
        person_age = findViewById(R.id.et_age);
        result = findViewById(R.id.result);
    }

    public void saveData(View view) {
        // TODO: Save the data into the shared preferences file
        String name = person_name.getText().toString();
        int age = Integer.parseInt(person_age.getText().toString());

        // logic to save data into the file of internal storage goes here
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write((name+"\n"+age).getBytes());
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        person_name.getText().clear();
        person_age.getText().clear();

        Toast.makeText(this, "Data successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        // TODO: load the data from the shared preferences file
        result.setText("");
        FileInputStream fis;
        try{
            fis = openFileInput(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine())!=null){
                builder.append(line+"\n");
            }

            result.setText(builder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}