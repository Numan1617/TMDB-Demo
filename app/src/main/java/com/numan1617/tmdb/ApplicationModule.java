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

package com.numan1617.tmdb;

import com.numan1617.api.ConfigurationService;
import com.numan1617.tmdb.repository.ConfigurationRepository;
import com.numan1617.tmdb.repository.ConfigurationStorage;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final TmdbApplication app;

    public ApplicationModule(TmdbApplication app) {
        this.app = app;
    }

    @Provides
    Application provideApplication() {
        return app;
    }

    @Provides
    Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    ConfigurationStorage providesConfigurationStorage(Context context) {
        return new ConfigurationStorage(context);
    }

    @Provides
    ConfigurationRepository provideConfigurationRepository(ConfigurationService configurationService,
            ConfigurationStorage configurationStorage) {
        return new ConfigurationRepository(configurationService, configurationStorage);
    }
}
