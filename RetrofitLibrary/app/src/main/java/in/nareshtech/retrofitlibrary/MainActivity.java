package in.nareshtech.retrofitlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    Retrofit retrofit;
    JsonTypicodeInterface inter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.data_here);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        inter = retrofit.create(JsonTypicodeInterface.class);
    }

    public void getData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");
        inter.getAllPosts().enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                progressBar.setVisibility(View.GONE);
                List<Datum> data = response.body();
                for(Datum d1: data){
                    textView.append(d1.getTitle()+"\n");
                }
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                textView.setText(t.getMessage());
            }
        });
    }
}