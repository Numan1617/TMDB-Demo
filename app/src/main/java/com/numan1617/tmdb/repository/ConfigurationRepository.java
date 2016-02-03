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

package com.numan1617.tmdb.repository;

import com.numan1617.api.ConfigurationService;

import android.support.annotation.NonNull;

import rx.Observable;

public class ConfigurationRepository {

    private final ConfigurationService configurationService;
    private final ConfigurationStorage configurationStorage;

    public ConfigurationRepository(@NonNull final ConfigurationService configurationService,
            @NonNull final ConfigurationStorage configurationStorage) {
        this.configurationService = configurationService;
        this.configurationStorage = configurationStorage;
    }

    public Observable<TMDBConfiguration> configuration() {
        return Observable.concat(
                configurationStorage.configuration(),
                configurationService.configuration()
                        .map(TMDBConfiguration::from)
                        .doOnNext(configurationStorage::saveConfiguration))
                .first(configuration -> configuration != null && configuration.isUpToDate());
    }
}
