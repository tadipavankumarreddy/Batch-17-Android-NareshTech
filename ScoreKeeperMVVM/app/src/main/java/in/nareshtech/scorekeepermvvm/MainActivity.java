package in.nareshtech.scorekeepermvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.nareshtech.scorekeepermvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mvm = new ViewModelProvider(this).get(MainViewModel.class);

        if(mvm.count.getValue()!=0){
            binding.result.setText(String.valueOf(mvm.count.getValue()));
        }

        binding.plusBtn.setOnClickListener(v -> {
            mvm.increment();
        });

        binding.minusBtn.setOnClickListener(v -> {
            mvm.decrement();
        });

        mvm.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.result.setText(String.valueOf(mvm.count.getValue()));
            }
        });
    }
}