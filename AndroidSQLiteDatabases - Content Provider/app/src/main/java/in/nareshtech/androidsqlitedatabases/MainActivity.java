package in.nareshtech.androidsqlitedatabases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.et_name);
        person_age = findViewById(R.id.et_age);
        result = findViewById(R.id.result);

        helper = new DBHelper(this);
    }

    public void saveData(View view) {
        String name = person_name.getText().toString();
        int age = Integer.parseInt(person_age.getText().toString());
        // Logic to save data into the table
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_2,name);
        values.put(DBHelper.COL_3,age);
        helper.insertData(values);

        person_name.getText().clear();
        person_age.getText().clear();
        Toast.makeText(this, "Data successfully saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData2(View view) {
        // TODO: load the data from the shared preferences file
        result.setText("");
        Cursor c = helper.getData();
        c.moveToFirst();
        do{
            result.append(c.getInt(0)+"\n"+c.getString(1)+"\n"+c.getInt(2)+"\n\n");
        }while(c.moveToNext());
    }
}