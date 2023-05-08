package in.nareshtech.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RedFragment extends Fragment implements View.OnClickListener {

    private EditText num1, num2;
    private Button plus,minus,prod,divi;
    private TextView tv;

    public RedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red, container, false);

        // we write the logic for the design
        initializeMyViews(v);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        prod.setOnClickListener(this);
        divi.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int n3 = 0;
        if(v.getId() == R.id.plus_btn){
            n3 = n1+n2;
        }

        if(v.getId() == R.id.minus_btn){
            n3 = n1-n2;
        }

        if(v.getId() == R.id.product_btn){
            n3 = n1*n2;
        }

        if(v.getId() == R.id.divi_btn){
            n3 = n1/n2;
        }

        tv.setText(String.valueOf(n3));
    }

    private void initializeMyViews(View v) {
        num1 = v.findViewById(R.id.number1);
        num2 = v.findViewById(R.id.number2);
        plus = v.findViewById(R.id.plus_btn);
        minus = v.findViewById(R.id.minus_btn);
        prod = v.findViewById(R.id.product_btn);
        divi = v.findViewById(R.id.divi_btn);
        tv = v.findViewById(R.id.result);
    }
}