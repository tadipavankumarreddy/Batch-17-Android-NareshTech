package in.nareshtech.fragcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentListener {

    FirstFragment fragment1;
    SecondFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: load these fragments on the MainActivity
        FragmentManager manager = getSupportFragmentManager();
        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();

        manager.beginTransaction().replace(R.id.linearLayout,fragment1)
                .replace(R.id.linearLayout2,fragment2)
                .commit();
    }

    @Override
    public void sendDataToSecondFragment(String data) {
        fragment2.updateData(data);
    }
}