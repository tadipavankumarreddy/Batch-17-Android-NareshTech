package in.nareshtech.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MAIN","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MAIN","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MAIN","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MAIN","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MAIN","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MAIN","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MAIN","onRestart()");
    }

    
}