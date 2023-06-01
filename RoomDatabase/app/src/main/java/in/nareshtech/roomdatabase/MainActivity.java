package in.nareshtech.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import in.nareshtech.roomdatabase.Databases.Person;
import in.nareshtech.roomdatabase.Databases.PersonDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;

    // TODO 4: create an object for the database abstract class and initialize
    //  it before proceeding to perform the operations
    PersonDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_name = findViewById(R.id.et_name);
        person_age = findViewById(R.id.et_age);
        result = findViewById(R.id.result);

        database = Room.databaseBuilder(this,PersonDatabase.class,"Pavan.db")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());
        // Logic to insert the values in the table.
        Person p = new Person(n,a);
        database.personDAO().insertValues(p);
        Snackbar.make(view, "Data Inserted", BaseTransientBottomBar.LENGTH_LONG).show();

        person_name.getText().clear();
        person_age.getText().clear();
    }

    public void loadData(View view) {
        List<Person> personList = database.personDAO().getAllData();
        result.setText("");
        for(Person p: personList){
            result.append(p.getPerson_id()+" "+p.getPerson_name()+" "+p.getPerson_age()+"\n\n");
        }
    }
}