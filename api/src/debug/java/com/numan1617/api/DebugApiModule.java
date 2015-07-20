package com.numan1617.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.converter.Converter;

/**
 * Created by jamesnewman on 04/06/15.
 */
@Module(includes = ApiModule.class)
public final class DebugApiModule {

    @Provides
    @IsMockMode
    boolean provideIsMockMode() {
        return false;
    }

    @Provides
    @Singleton
    MockRestAdapter provideMockRestAdapter( RestAdapter restAdapter) {
        return MockRestAdapter.from(restAdapter);
    }

    @Provides
    @Singleton
    MovieService provideMovieService(RestAdapter restAdapter, MockRestAdapter mockRestAdapter, Converter converter, @IsMockMode boolean isMockMode) {
        if (isMockMode) {
            return mockRestAdapter.create(MovieService.class, new MockMovieService(converter));
        }
        return restAdapter.create(MovieService.class);
    }

    @Provides
    RestAdapter.LogLevel provideLogLevel() {
        return RestAdapter.LogLevel.FULL;
    }
}
