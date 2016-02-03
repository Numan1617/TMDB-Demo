package com.numan1617.tmdb;

import com.numan1617.api.ApiComponent;
import com.numan1617.api.MovieService;
import com.numan1617.tmdb.repository.ConfigurationRepository;

import dagger.Component;

/**
 * Created by jamesnewman on 20/07/15.
 */
@ApplicationScope
@Component(
        dependencies = {ApiComponent.class},
        modules = ApplicationModule.class
)
public interface TmdbApplicationComponent {
    MovieService movieService();
    ConfigurationRepository configurationRepository();

    void inject(TmdbApplication application);
}
