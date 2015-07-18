package com.numan1617.api.model;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.Collection;
import java.util.List;

import lombok.Data;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Data
public class Movie {

    @SerializedName("id")
    private final Integer id;

    @SerializedName("adult")
    private final Boolean adult;

    @SerializedName("backdrop_path")
    private final String backdropPath;

    @SerializedName("belongs_to_collection")
    private final Collection belongsToCollection;

    @SerializedName("budget")
    private final Integer budget;

    @SerializedName("genres")
    private final List<Genre> genres;

    @SerializedName("homepage")
    private final String homepage;

    @SerializedName("imdb_id")
    private final String imdbId;

    @SerializedName("original_language")
    private final String originalLanguage;

    @SerializedName("original_title")
    private final String originalTitle;

    @SerializedName("overview")
    private final String overview;

    @SerializedName("popularity")
    private final Double popularity;

    @SerializedName("poster_path")
    private final String posterPath;

    @SerializedName("production_companies")
    private final List<ProductionCompany> productionCompanies;

    @SerializedName("production_countries")
    private final List<ProductionCountry> productionCountries;

    @SerializedName("release_date")
    private final DateTime releaseDate;

    @SerializedName("revenue")
    private final Integer revenue;

    @SerializedName("runtime")
    private final Integer runtime;

    @SerializedName("spoken_languages")
    private final List<SpokenLanguage> spokenLanguages;

    @SerializedName("status")
    private final String status;

    @SerializedName("tagline")
    private final String tagline;

    @SerializedName("title")
    private final String title;

    @SerializedName("vote_average")
    private final Double voteAverage;

    @SerializedName("vote_count")
    private final Integer voteCount;
}
