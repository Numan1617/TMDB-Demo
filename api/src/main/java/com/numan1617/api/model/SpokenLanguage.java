package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Data
public class SpokenLanguage {

    @SerializedName("iso_639_1")
    private final String iso639_1;

    @SerializedName("name")
    private final String name;
}
