package in.nareshtech.firebaserealtimedatabases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText person_name, person_age;
    private TextView result;
    private ProgressBar progressBar;

    // Step 1: Create and intialize databasereference
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person_age = findViewById(R.id.et_age);
        person_name = findViewById(R.id.et_name);
        result = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        dbr = FirebaseDatabase.getInstance().getReference("Person");
    }

    public void loadData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        dbr.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.INVISIBLE);
                result.setText("");
                for(DataSnapshot d: snapshot.getChildren()){
                    Person p = d.getValue(Person.class);
                    result.append(p.getName()+" "+p.getAge()+"\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Task cancelled", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        String n = person_name.getText().toString();
        int a = Integer.parseInt(person_age.getText().toString());

        // Step2: convert the data to model object
        Person p = new Person(n,a);
        dbr.push().setValue(p).addOnSuccessListener(unused -> {
            // If data is successfully put on Realtime Databases we come here
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }).addOnFailureListener(e -> {
            // we come here if we are unsuccessful
            Toast.makeText(this, "Not Successful", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        });

        person_name.getText().clear();
        person_age.getText().clear();
    }
}