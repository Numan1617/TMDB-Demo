package com.numan1617.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.converter.Converter;

/**
 * Created by jamesnewman on 04/06/15.
 */
@Module(includes = ApiModule.class)
public final class ReleaseApiModule {

    @Provides
    @Singleton
    MovieService provideMovieService(RestAdapter restAdapter, Converter converter) {
        return restAdapter.create(MovieService.class);
    }

    @Provides
    @Singleton
    ConfigurationService provideConfigurationService(RestAdapter restAdapter, Converter converter) {
        return restAdapter.create(ConfigurationService.class);
    }

    @Provides
    RestAdapter.LogLevel provideLogLevel() {
        return RestAdapter.LogLevel.NONE;
    }
}
