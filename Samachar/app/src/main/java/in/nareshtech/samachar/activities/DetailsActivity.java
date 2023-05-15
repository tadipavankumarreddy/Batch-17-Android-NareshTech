package in.nareshtech.samachar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.net.Uri;
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

    Datum d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.details_image);
        title = findViewById(R.id.details_title);
        content = findViewById(R.id.details_content);

        Intent i = getIntent();
        d = (Datum) i.getSerializableExtra("DATA");

        Glide.with(this).load(d.getImageUrl()).into(imageView);
        title.setText(d.getTitle());
        content.setText(d.getContent());
    }

    public void readMore(View view) {
        /*Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(d.getReadMoreUrl()));
        startActivity(i);*/
        CustomTabsIntent intent = new CustomTabsIntent.Builder()
                .build();
        intent.launchUrl(DetailsActivity.this, Uri.parse(d.getReadMoreUrl()));
    }

    public void readOriginal(View view) {
        /*Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(d.getUrl()));
        startActivity(i);*/
        CustomTabsIntent intent = new CustomTabsIntent.Builder()
                .build();
        intent.launchUrl(DetailsActivity.this, Uri.parse(d.getUrl()));
    }
}