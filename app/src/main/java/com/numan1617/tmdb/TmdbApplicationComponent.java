package com.numan1617.tmdb;

import com.numan1617.api.ApiComponent;
import com.numan1617.api.MovieService;

import dagger.Component;

/**
 * Created by jamesnewman on 20/07/15.
 */
@ApplicationScope
@Component(
        dependencies = {ApiComponent.class}
)
public interface TmdbApplicationComponent {
    MovieService movieService();

    void inject(TmdbApplication application);
}
