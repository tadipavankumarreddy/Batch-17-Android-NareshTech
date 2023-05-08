package in.nareshtech.fragcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private  FirstFragmentListener listener;
    private Button b;
    private EditText et;
    public interface FirstFragmentListener{
        void sendDataToSecondFragment(String data);
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        et = v.findViewById(R.id.et1);
        b = v.findViewById(R.id.senddata);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendDataToSecondFragment(et.getText().toString());
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentListener){
            listener = (FirstFragmentListener) context;
        }else{
            Toast.makeText(context, "Implement the listener", Toast.LENGTH_SHORT).show();
        }
    }
}