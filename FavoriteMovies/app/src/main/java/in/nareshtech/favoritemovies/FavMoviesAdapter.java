package in.nareshtech.favoritemovies;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavMoviesAdapter extends RecyclerView.Adapter<FavMoviesAdapter.FavMoviesViewHolder> {

    Context context;
    List<FavMovie> movies;

    public FavMoviesAdapter(Context context, List<FavMovie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // this method attaches the copy of layout file (one_item_design) to the recyclerview.
    @NonNull
    @Override
    public FavMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false);
        return new FavMoviesViewHolder(v);
    }

    // We actually populate data on the recyclerview items based on the position
    @Override
    public void onBindViewHolder(@NonNull FavMoviesViewHolder holder, int position) {
        holder.poster.setImageResource(movies.get(position).getPosterId());
        holder.movie_name.setText(movies.get(position).getMovieName());
        holder.actor_name.setText(movies.get(position).getLeadActor());
    }

    // This tells the adapter about the total number of items it has to take care of
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class FavMoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener/*, DialogInterface.OnClickListener*/ {

        ImageView poster;
        TextView movie_name, actor_name;

        public FavMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.imageView);
            movie_name = itemView.findViewById(R.id.movie_name_tv);
            actor_name = itemView.findViewById(R.id.movie_actor_tv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
           /* // get the exact position of the click
            int position = getAdapterPosition();
            // Extract Data
            FavMovie fm = movies.get(position);

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setIcon(R.drawable.baseline_info_24);
            dialogBuilder.setTitle(fm.getMovieName());
            dialogBuilder.setMessage(fm.getLeadActor()+" is the protagonist in the movie");

            dialogBuilder.setPositiveButton("OK",this);
            dialogBuilder.setNegativeButton("Cancel", this);
            dialogBuilder.setNeutralButton("Close",this);
            
            dialogBuilder.show();*/
            Intent i = new Intent(context, DetailsActivity.class);
            i.putExtra("DATAKEY",movies.get(getAdapterPosition()));
            context.startActivity(i);
        }

        /*@Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(context, "Thanks for clicking on the button", Toast.LENGTH_SHORT).show();
        }*/
    }
}