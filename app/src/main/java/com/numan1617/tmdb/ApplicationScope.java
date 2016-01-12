package com.numan1617.tmdb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by jamesnewman on 20/07/15.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
