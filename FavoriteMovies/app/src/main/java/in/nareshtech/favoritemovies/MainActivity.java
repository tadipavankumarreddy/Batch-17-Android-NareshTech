package in.nareshtech.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FavMovie> moviesList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Step 1:Prepare Data
        initData();
        recyclerView = findViewById(R.id.recyclerview);
        FavMoviesAdapter fma = new FavMoviesAdapter(this,moviesList);
        recyclerView.setAdapter(fma);

        // Now you can arrange the items based on your interest
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));*/
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        /*recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));*/
    }

    private void initData() {
        moviesList = new ArrayList<>();

        FavMovie athadu = new FavMovie(R.drawable.a, "Athadu", "Mahesh","Athadu is a 2005 Indian Telugu-language action thriller film written and directed by Trivikram Srinivas.[2] The film stars Mahesh Babu, Trisha, and Sonu Sood while Sayaji Shinde, Kota Srinivasa Rao, Prakash Raj, Nassar, and Brahmanandam play supporting roles.[3] It is produced by D. Kishore and M. Ram Mohan under the Jayabheri Arts banner. The soundtrack was composed by Mani Sharma. K. V. Guhan handled the cinematography of the film while Sreekar Prasad edited it.");
        FavMovie balu = new FavMovie(R.drawable.b, "Balu", "Pawan","Balu: ABCDEFG is a 2005 Indian Telugu-language crime action film written and directed by A. Karunakaran.[2] This film stars Pawan Kalyan, Shriya, debutante Neha Oberoi and Gulshan Grover. The film was produced by C. Ashwini Dutt under his production company Vyjayanthi Movies.[3] It's tag-line ABCDEFG stands for \"A Boy Can Do Everything For a Girl.\" The film was released on 6 January 2005.");
        FavMovie chandaramukhi = new FavMovie(R.drawable.c, "Chandramukhi", "Rajini","adfadfa");
        FavMovie dj = new FavMovie(R.drawable.d, "DJ", "Arjun","adfasdfa");
        FavMovie eega = new FavMovie(R.drawable.e, "Eega", "Samantha","adfadfa");
        FavMovie f3 = new FavMovie(R.drawable.f, "F3", "Venkatesh","adfadfa");
        FavMovie ganga = new FavMovie(R.drawable.g, "Ganga", "Lawrence","adfadfa");
        FavMovie hridayam = new FavMovie(R.drawable.h, "Hridayam", "Pranav","afdadfa");
        FavMovie i = new FavMovie(R.drawable.i, "I", "Vikram","afdasdfa");
        FavMovie jaanu = new FavMovie(R.drawable.j, "Jaanu", "Sarvanand","adfadf");


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

