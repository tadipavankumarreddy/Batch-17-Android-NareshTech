package in.nareshtech.favoritemovies;

import java.io.Serializable;

public class FavMovie implements Serializable {
   private int posterId;
   private String movieName;
   private String leadActor;

   private String description;

    public FavMovie() {
        // We need an Empty Constructor
    }

    public FavMovie(int posterId, String movieName, String leadActor, String description) {
        this.posterId = posterId;
        this.movieName = movieName;
        this.leadActor = leadActor;
        this.description = description;
    }

    public int getPosterId() {
        return posterId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getDescription() {
        return description;
    }
}
