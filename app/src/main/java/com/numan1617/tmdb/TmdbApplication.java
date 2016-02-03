package com.numan1617.tmdb;

import com.numan1617.api.ApiComponent;
import com.numan1617.api.DaggerApiComponent;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;

/**
 * Created by jamesnewman on 20/07/15.
 */
public class TmdbApplication extends Application {

    private TmdbApplicationComponent applicationComponent;

    public static TmdbApplication get(Context context) {
        return (TmdbApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }

        ApiComponent apiComponent = DaggerApiComponent.create();
        applicationComponent = DaggerTmdbApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .apiComponent(apiComponent)
                .build();
        applicationComponent.inject(this);
    }

    public TmdbApplicationComponent component() {
        return applicationComponent;
    }
}
