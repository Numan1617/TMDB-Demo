package com.numan1617.tmdb.feature.upcoming;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.numan1617.api.MovieService;
import com.numan1617.api.model.Movie;
import com.numan1617.api.model.PagedResults;
import com.numan1617.tmdb.R;
import com.numan1617.tmdb.TmdbApplicationComponent;
import com.numan1617.tmdb.base.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by jamesnewman on 20/07/15.
 */
public class UpcomingMoviesActivity extends BaseActivity {

    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Bind(R.id.recycler_movie_list)
    RecyclerView movieList;

    @Inject
    UpcomingMovieListAdapter movieListAdapter;

    @Inject
    MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        setupMovieList();
        getUpcomingMoviesForPage(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        compositeSubscription.unsubscribe();
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

    private void getUpcomingMoviesForPage(int page) {
        compositeSubscription.add(movieService.getUpcomingMovies(page, "en")
                        .subscribe(new Observer<PagedResults<Movie>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Timber.e(e, "movieService.getUpcomingMovies onError");
                            }

                            @Override
                            public void onNext(PagedResults<Movie> moviePagedResults) {
                                movieListAdapter.setMovies(moviePagedResults.getResults());
                            }
                        })
        );
    }
}
