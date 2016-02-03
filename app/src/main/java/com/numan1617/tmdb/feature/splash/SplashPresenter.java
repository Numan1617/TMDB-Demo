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

import com.numan1617.tmdb.repository.ConfigurationRepository;

import android.support.annotation.NonNull;

public class SplashPresenter {

    private final View view;
    private final ConfigurationRepository configurationRepository;

    public SplashPresenter(@NonNull final View view, @NonNull final ConfigurationRepository configurationRepository) {
        this.view = view;
        this.configurationRepository = configurationRepository;
    }

    public void initialise() {
        configurationRepository.configuration()
                .subscribe(
                        ignored -> view.goToMoviesList(),
                        Throwable::printStackTrace
                );
    }

    public interface View {

        void goToMoviesList();
    }
}
