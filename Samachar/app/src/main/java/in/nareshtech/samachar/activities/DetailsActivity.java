package in.nareshtech.samachar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.nareshtech.samachar.R;
import in.nareshtech.samachar.model.Datum;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.details_image);
        title = findViewById(R.id.details_title);
        content = findViewById(R.id.details_content);

        Intent i = getIntent();
        Datum d = (Datum) i.getSerializableExtra("DATA");

        Glide.with(this).load(d.getImageUrl()).into(imageView);
        title.setText(d.getTitle());
        content.setText(d.getContent());
    }

    public void readMore(View view) {

    }

    public void readOriginal(View view) {

    }
}