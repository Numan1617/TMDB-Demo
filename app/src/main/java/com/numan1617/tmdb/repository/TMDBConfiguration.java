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

import com.numan1617.api.model.Configuration;

import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

import android.support.annotation.NonNull;

import lombok.Data;

@Data(staticConstructor="from")
public class TMDBConfiguration {

    private final String baseImageUrl;
    private final Instant lastUpdated;

    public static TMDBConfiguration from(@NonNull final Configuration configuration) {
        return new TMDBConfiguration(
                configuration.getImageConfiguration().getSecureBaseUrl(),
                Instant.now()
        );
    }

    public boolean isUpToDate() {
        Duration durationSinceLastUpdate = Duration.between(lastUpdated, Instant.now());
        return durationSinceLastUpdate.toDays() < 7;
    }
}
