package in.nareshtech.scorekeepermvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> count;
    public MainViewModel() {
        // this the place where the viewmodel is initialized
        Log.v("MAIN","ViewModel is created");
        count = new MutableLiveData<>();
        count.setValue(0);
    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        //this the place where the viewmodel is destroyed
        Log.v("MAIN","ViewModel is Destroyed");
    }
}
