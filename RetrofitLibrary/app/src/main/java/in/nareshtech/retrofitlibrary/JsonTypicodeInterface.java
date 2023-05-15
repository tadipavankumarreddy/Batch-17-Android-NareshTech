package in.nareshtech.retrofitlibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonTypicodeInterface {

    @GET("posts")
    Call<List<Datum>> getAllPosts();
}
