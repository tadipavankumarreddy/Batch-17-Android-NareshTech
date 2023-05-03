package in.nareshtech.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView iv;
    TextView movie_name, artist_name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        iv = findViewById(R.id.imageView2);
        movie_name = findViewById(R.id.movie_ttv);
        artist_name = findViewById(R.id.actor_ttv);
        description = findViewById(R.id.movie_desc_ttv);

        Intent i = getIntent();
        FavMovie movie = (FavMovie) i.getSerializableExtra("DATAKEY");
        iv.setImageResource(movie.getPosterId());
        movie_name.setText(movie.getMovieName());
        artist_name.setText(movie.getLeadActor());
        description.setText(movie.getDescription());
    }
}