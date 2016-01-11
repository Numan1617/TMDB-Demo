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

package com.numan1617.api;

import com.numan1617.api.model.Configuration;

import retrofit.http.GET;
import rx.Observable;

public interface ConfigurationService {

    /**
     * Get the system wide configuration information. Some elements of the API require some knowledge of this
     * configuration data. The purpose of this is to try and keep the actual API responses as light as possible. It is
     * recommended you cache this data within your application and check for updates every few days.
     *
     * This method currently holds the data relevant to building image URLs as well as the change key map.
     *
     * To build an image URL, you will need 3 pieces of data. The base_url, size and file_path. Simply combine them all
     * and you will have a fully qualified URL. Here’s an example URL:
     *
     * http://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg
     */
    @GET("configuration")
    Observable<Configuration> configuration();
}
