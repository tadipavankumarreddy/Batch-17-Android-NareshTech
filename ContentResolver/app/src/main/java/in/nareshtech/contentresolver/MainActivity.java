package in.nareshtech.contentresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String authorities = "in.nareshtech.ContentProvider";
    public static final String COL_2 = "person_name";
    public static final String COL_3 = "person_age";

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textvirew);

        // A proper content provider URI will have the "content://" as the prefix
        Uri uri = Uri.parse("content://"+authorities);

        // The following logic is for inserting data into the other apps database
        /*ContentValues values = new ContentValues();
        values.put(COL_2,"Rama");
        values.put(COL_3,16);
        
        // Do a Insert Request - throguh a content Resolver
        getContentResolver().insert(uri,values);
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();*/

        Cursor c = getContentResolver().query(uri,null,null,null,null);
        c.moveToFirst();
        textView.setText("");
        do{
            textView.append(c.getInt(0)+"\n"+c.getString(1)+"\n"+c.getInt(2)+"\n\n");
        }while(c.moveToNext());
    }
}