package com.numan1617.api;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jamesnewman on 04/06/15.
 */
@Qualifier
@Retention(RUNTIME)
public @interface IsMockMode {
}
