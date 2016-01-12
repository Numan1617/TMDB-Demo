package com.numan1617.tmdb.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.numan1617.tmdb.TmdbApplication;
import com.numan1617.tmdb.TmdbApplicationComponent;

/**
 * Created by jamesnewman on 20/07/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());

        TmdbApplication app = TmdbApplication.get(this);
        onCreateComponent(app.component());
    }

    protected abstract void onCreateComponent(TmdbApplicationComponent applicationComponent);

    @LayoutRes
    protected abstract int layoutId();
}
