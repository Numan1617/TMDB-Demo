/*
 * Copyright 2016 James Newman (Numan1617)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.numan1617.tmdb.feature.splash;

import com.numan1617.tmdb.R;
import com.numan1617.tmdb.TmdbApplicationComponent;
import com.numan1617.tmdb.base.BaseActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashPresenter.View {

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.initialise();
    }

    @Override
    protected void onCreateComponent(TmdbApplicationComponent applicationComponent) {
        DaggerSplashComponent.builder()
                .tmdbApplicationComponent(applicationComponent)
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void goToMoviesList() {

    }
}
