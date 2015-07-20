package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Data
public class ProductionCompany {

    @SerializedName("id")
    private final Integer id;

    @SerializedName("name")
    private final String name;
}
