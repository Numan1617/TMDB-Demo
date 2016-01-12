package com.numan1617.tmdb.feature.upcoming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.numan1617.api.model.Movie;
import com.numan1617.tmdb.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jamesnewman on 21/07/15.
 */
class UpcomingMovieListAdapter extends RecyclerView.Adapter<UpcomingMovieListAdapter.MovieViewHolder> {

    private final Context context;

    private List<Movie> movies = new ArrayList<>();

    UpcomingMovieListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bindTo(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.text_movie_title)
        TextView movieTitle;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(Movie movie) {
            movieTitle.setText(movie.getTitle());
        }
    }
}
