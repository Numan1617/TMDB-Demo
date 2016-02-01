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

import com.numan1617.api.ConfigurationService;
import com.numan1617.api.model.Configuration;

import android.support.annotation.NonNull;

import rx.functions.Action1;

public class SplashPresenter {

    private final View view;
    private final ConfigurationService configurationService;

    public SplashPresenter(@NonNull final View view, @NonNull final ConfigurationService configurationService) {
        this.view = view;
        this.configurationService = configurationService;
    }

    public void initialise() {
        configurationService.configuration()
                .subscribe(
                        new Action1<Configuration>() {
                            @Override
                            public void call(Configuration configuration) {
                                saveConfiguration(configuration);
                            }
                        }
                );
    }

    private void saveConfiguration(@NonNull final Configuration configuration) {

    }

    public interface View {

    }
}
