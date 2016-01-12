package com.numan1617.tmdb;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jamesnewman on 20/07/15.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
