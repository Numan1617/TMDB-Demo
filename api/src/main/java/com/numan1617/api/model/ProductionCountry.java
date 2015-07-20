package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Data
public class ProductionCountry {

    @SerializedName("iso_3166_1")
    private final String iso3166_1;

    @SerializedName("name")
    private final String name;
}
