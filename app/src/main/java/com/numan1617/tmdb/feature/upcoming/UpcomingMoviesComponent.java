package com.numan1617.tmdb.feature.upcoming;

import com.numan1617.tmdb.PerActivity;
import com.numan1617.tmdb.TmdbApplicationComponent;

import dagger.Component;

/**
 * Created by jamesnewman on 21/07/15.
 */
@PerActivity
@Component(
        dependencies = TmdbApplicationComponent.class,
        modules = UpcomingMoviesModule.class
)
interface UpcomingMoviesComponent {
    void inject(UpcomingMoviesActivity activity);
}
