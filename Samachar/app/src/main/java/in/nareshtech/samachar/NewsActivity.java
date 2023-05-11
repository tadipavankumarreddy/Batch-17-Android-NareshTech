package in.nareshtech.samachar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private String BASE_URL = "https://inshorts.deta.dev/news?category=";
    private TextView textView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        textView = findViewById(R.id.textView2);
        progressBar = findViewById(R.id.progressBar);
        Intent i = getIntent();

        String cat = i.getStringExtra("CAT");

        RequestQueue queue = Volley.newRequestQueue(this);
        String properURL = BASE_URL+cat;

        StringRequest request = new StringRequest(Request.Method.GET, properURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // this gets invoked after receiving the response from the url
                progressBar.setVisibility(View.INVISIBLE);
                textView.setText("");
                /*// How we parse JSON data manually ?
                List<Article> newsArticles = new ArrayList<>();
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray jsonArray = obj.getJSONArray("data");
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String title = item.getString("title");
                        String author = item.getString("author");
                        String url = item.getString("url");
                        String date = item.getString("date");
                        String readMoreUrl = item.getString("readMoreUrl");
                        String imageURL = item.getString("imageUrl");
                        String content = item.getString("content");
                        Article a = new Article(title,content,author,date,url,imageURL,readMoreUrl);
                        newsArticles.add(a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                Gson gson = new Gson();
                Source s = gson.fromJson(response,Source.class);
                for(Datum d: s.getData()){
                    textView.append(d.getTitle()+"\n\n");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // this gets invoked when there is an error
                progressBar.setVisibility(View.INVISIBLE);
                textView.setText(error.getMessage());
            }
        });

        queue.add(request);
    }
}