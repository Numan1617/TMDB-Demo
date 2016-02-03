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

import org.threeten.bp.Instant;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import rx.Observable;

public class ConfigurationStorage {

    private static final String KEY_BASE_IMAGE_URL = "KEY_BASE_IMAGE_URL";
    private static final String KEY_LAST_UPDATED = "KEY_LAST_UPDATED";

    private final SharedPreferences sharedPreferences;

    public ConfigurationStorage(@NonNull final Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveConfiguration(TMDBConfiguration configuration) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_BASE_IMAGE_URL, configuration.getBaseImageUrl());
        editor.putString(KEY_LAST_UPDATED, configuration.getLastUpdated().toString());
        editor.apply();
    }

    public Observable<TMDBConfiguration> configuration() {
        return Observable.combineLatest(
                Observable.just(sharedPreferences.getString(KEY_BASE_IMAGE_URL, null)),
                Observable.just(sharedPreferences.getString(KEY_LAST_UPDATED, null)),
                (baseImageUrl, lastUpdated) -> TMDBConfiguration.from(baseImageUrl, Instant.parse(lastUpdated))
        );
    }
}
