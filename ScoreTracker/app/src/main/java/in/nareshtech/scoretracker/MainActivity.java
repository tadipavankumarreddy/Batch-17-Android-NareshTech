package in.nareshtech.scoretracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*private Button plusBtn, minusBtn;*/
    private TextView result;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objects are connected to the actual views on the screen through their IDs
       /* plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);*/
        result = findViewById(R.id.result);

        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("COUNT_VAL");
            result.setText(String.valueOf(count));
        }

        // You must listen to the button clicks so that the score on the Textview can be increased or decreased.
        /*plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Here we can perform the logic of incrementing the score
                count++;
                result.setText(String.valueOf(count));
            }
        });*/
        /*minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Here we can write logic to decrement the score
                count--;
                result.setText(String.valueOf(count));
            }
        });*/
    }

    public void incrementScore(View view) {
        // this method is invoked as soon as the plus button is tapped
        count++;
        result.setText(String.valueOf(count));
    }


    public void decrementScore(View view) {
        // this method is invoked as soon as the minus button is tapped
        count--;
        result.setText(String.valueOf(count));
    }

    // The activity always gets destroyed and then recreated for every screen rotation (Configuration change)

    // This method can save our data into outstate (bundle Object) during the destruction of the activity
    // and hands this data over to onCreate Method as the activity re-creates.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_VAL",count);
    }

    // if you want to attach an options_menu file to the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // logic goes here
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Inorder to get these menu options work for us., we need another method
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // logic goes here
        switch (item.getItemId()){
            case R.id.reset_score:
                count = 0;
                result.setText(String.valueOf(count));
                break;

            case R.id.show_toast:
                Toast.makeText(this, "This is toast", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}