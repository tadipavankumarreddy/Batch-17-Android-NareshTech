package in.nareshtech.multiplelanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText person_name;
    private TextView result;

    DBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.editTextText);
        result = findViewById(R.id.result);

        dBhelper = new DBhelper(this);
    }

    public void saveData(View view) {
        String n = person_name.getText().toString();
        ContentValues values = new ContentValues();
        values.put(DBhelper.COL_1, n);
        dBhelper.insertData(values);
    }

    public void loadData(View view) {
        Cursor c = dBhelper.getAllData();
        c.moveToFirst();
        result.setText("");
        do{
            int id = c.getInt(0);
            String n = c.getString(1);
            result.append(id+"  "+n+"\n");
        }while(c.moveToNext());
    }
}