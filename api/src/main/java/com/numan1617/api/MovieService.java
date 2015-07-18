package com.numan1617.api;

import com.numan1617.api.model.Movie;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by jamesnewman on 18/07/15.
 */
public interface MovieService {

    @GET("/movie/{id}")
    Observable<Movie> getMovieById(
            @Path("id") int id,
            @Query("language") String language
    );
}
