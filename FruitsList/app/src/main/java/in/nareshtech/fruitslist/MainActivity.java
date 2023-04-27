package in.nareshtech.fruitslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String[] fruits;
    private int[] fruits_images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruits = new String[]{"Apple","Banana","Guava","Grapes","Mango",
                "Sapota","Orange"};

        fruits_images = new int[]{R.drawable.a,R.drawable.banana,R.drawable.guava,R.drawable.grapes,
        R.drawable.mango,R.drawable.sapota,R.drawable.orange};

        lv  = findViewById(R.id.fruits_list);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fruits);*/

        MyListViewAdapter adapter = new MyListViewAdapter();
        lv.setAdapter(adapter);
    }

    // TODO: Display a list of Fruit names on the ListView
    // We need to have a list of fruit names

    // TODO 2: Customize the ListView

    class MyListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.one_item_design,parent,false);
            }
            ((TextView)convertView.findViewById(R.id.fruit_name)).setText(fruits[position]);
            ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(fruits_images[position]);
            ((Button)convertView.findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, fruits[position], Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
}