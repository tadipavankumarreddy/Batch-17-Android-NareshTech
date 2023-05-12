package in.nareshtech.samachar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import in.nareshtech.samachar.adapters.NewsAdapter;
import in.nareshtech.samachar.R;
import in.nareshtech.samachar.model.Source;

public class NewsActivity extends AppCompatActivity implements
        Response.Listener<String>, Response.ErrorListener {

    private String BASE_URL = "https://inshorts.deta.dev/news?category=";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);

        Intent i = getIntent();

        String cat = i.getStringExtra("CAT");

        RequestQueue queue = Volley.newRequestQueue(this);
        String properURL = BASE_URL + cat;

        StringRequest request = new StringRequest(Request.Method.GET, properURL, this, this);

        queue.add(request);
    }

    @Override
    public void onResponse(String response) {
        progressBar.setVisibility(View.INVISIBLE);
        Gson gson = new Gson();
        Source s = gson.fromJson(response,Source.class);
        NewsAdapter adapter = new NewsAdapter(NewsActivity.this, s.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressBar.setVisibility(View.INVISIBLE);
    }
}