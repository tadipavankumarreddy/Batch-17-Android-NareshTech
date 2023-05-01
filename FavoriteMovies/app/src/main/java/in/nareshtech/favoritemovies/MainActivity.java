package in.nareshtech.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FavMovie> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Step 1:Prepare Data
        initData();
    }

    private void initData() {
        moviesList = new ArrayList<>();

        FavMovie athadu = new FavMovie(R.drawable.a, "Athadu", "Mahesh");
        FavMovie balu = new FavMovie(R.drawable.b, "Balu", "Pawan");
        FavMovie chandaramukhi = new FavMovie(R.drawable.c, "Chandramukhi", "Rajini");
        FavMovie dj = new FavMovie(R.drawable.d, "DJ", "Arjun");
        FavMovie eega = new FavMovie(R.drawable.e, "Eega", "Samantha");
        FavMovie f3 = new FavMovie(R.drawable.f, "F3", "Venkatesh");
        FavMovie ganga = new FavMovie(R.drawable.g, "Ganga", "Lawrence");
        FavMovie hridayam = new FavMovie(R.drawable.h, "Hridayam", "Pranav");
        FavMovie i = new FavMovie(R.drawable.i, "I", "Vikram");
        FavMovie jaanu = new FavMovie(R.drawable.j, "Jaanu", "Sarvanand");

        moviesList.add(athadu);
        moviesList.add(balu);
        moviesList.add(chandaramukhi);
        moviesList.add(dj);
        moviesList.add(eega);
        moviesList.add(f3);
        moviesList.add(ganga);
        moviesList.add(hridayam);
        moviesList.add(i);
        moviesList.add(jaanu);
    }
}

