package com.numan1617.api;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jamesnewman on 04/06/15.
 */
@Singleton
@Component(modules = { ReleaseApiModule.class })
public interface ApiComponent {
    MovieService movieService();
}
