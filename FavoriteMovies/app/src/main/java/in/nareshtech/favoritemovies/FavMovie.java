package in.nareshtech.favoritemovies;

public class FavMovie {
   private int posterId;
   private String movieName;
   private String leadActor;

    public FavMovie() {
        // We need an Empty Constructor
    }

    public FavMovie(int posterId, String movieName, String leadActor) {
        this.posterId = posterId;
        this.movieName = movieName;
        this.leadActor = leadActor;
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
}
