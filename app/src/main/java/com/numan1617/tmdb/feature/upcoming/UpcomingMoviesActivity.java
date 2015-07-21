package com.numan1617.tmdb.feature.upcoming;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.numan1617.tmdb.R;
import com.numan1617.tmdb.TmdbApplicationComponent;
import com.numan1617.tmdb.base.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jamesnewman on 20/07/15.
 */
public class UpcomingMoviesActivity extends BaseActivity {

    @Bind(R.id.recycler_movie_list)
    RecyclerView movieList;

    @Inject
    UpcomingMovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        setupMovieList();
    }

    private void setupMovieList() {
        movieList.setAdapter(movieListAdapter);
        movieList.setItemAnimator(new DefaultItemAnimator());
        movieList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreateComponent(TmdbApplicationComponent applicationComponent) {
        DaggerUpcomingMoviesComponent.builder()
                .upcomingMoviesModule(new UpcomingMoviesModule(this))
                .tmdbApplicationComponent(applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_upcoming_movies;
    }
}
