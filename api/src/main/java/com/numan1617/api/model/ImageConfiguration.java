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

package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class ImageConfiguration {

    @SerializedName("base_url")
    private final String baseUrl;

    @SerializedName("secure_base_url")
    private final String secureBaseUrl;

    @SerializedName("poster_sizes")
    private final List<String> posterSizes;

    @SerializedName("backdrop_sizes")
    private final List<String> backdropSizes;

    @SerializedName("profile_sizes")
    private final List<String> profileSizes;

    @SerializedName("logo_sizes")
    private final List<String> logoSizes;
}
