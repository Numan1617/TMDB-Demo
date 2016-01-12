package com.numan1617.tmdb.feature.upcoming;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jamesnewman on 20/07/15.
 */
@Module
class UpcomingMoviesModule {

    private final Context context;

    public UpcomingMoviesModule(Context context) {
        this.context = context;
    }

    @Provides
    UpcomingMovieListAdapter provideUpcomingMovieListAdapter() {
        return new UpcomingMovieListAdapter(context);
    }
}
