package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Data
public class PagedResults<T> {

    @SerializedName("results")
    private final List<T> results;

    @SerializedName("page")
    public Integer page;

    @SerializedName("total_pages")
    public Integer totalPages;

    @SerializedName("total_results")
    public Integer totalResults;
}
