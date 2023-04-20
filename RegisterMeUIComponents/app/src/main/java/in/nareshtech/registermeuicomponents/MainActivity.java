package in.nareshtech.registermeuicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;
    private RadioGroup radioGroup;
    private Spinner spinner;
    private String g = "No Submission";
    private String lang = "";
    private String c = "";

    private CheckBox eng, hin, tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.person_name);
        person_age = findViewById(R.id.person_age);
        result = findViewById(R.id.result);
        radioGroup = findViewById(R.id.gender);
        eng = findViewById(R.id.eng);
        hin = findViewById(R.id.hin);
        tel = findViewById(R.id.tel);
        spinner = findViewById(R.id.countries);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    c = parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    c = "Nothing Selected";
            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            /*if(checkedId == R.id.male){
                g = "Male";
            }else{
                g = "Female";
            }*/
            g = (checkedId == R.id.male)?"Male":"Female";
        });

    }

    public void submit(View view) {
        String name = person_name.getText().toString();
        int age = Integer.parseInt(person_age.getText().toString());

        if(eng.isChecked())
            lang = lang+"English\n";
        if(hin.isChecked())
            lang = lang+"Hindi\n";
        if(tel.isChecked())
            lang = lang+"Telugu\n";

        result.setText(name+"\n"+age+"\n"+g+"\n"+lang+"\n"+c);
    }
}