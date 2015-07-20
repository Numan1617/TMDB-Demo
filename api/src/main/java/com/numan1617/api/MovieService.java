package com.numan1617.api;

import com.numan1617.api.model.Movie;
import com.numan1617.api.model.PagedResults;

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

    @GET("/movie/{id}")
    Observable<Movie> getLatestMovie();

    @GET("/movie/upcoming")
    Observable<PagedResults<Movie>> getUpcomingMovies(
            @Query("page") Integer page,
            @Query("language") String language
    );

    @GET("/movie/now_playing")
    Observable<PagedResults<Movie>> getNowPlayingMovies(
            @Query("page") Integer page,
            @Query("language") String language
    );

    @GET("/movie/top_rated")
    Observable<PagedResults<Movie>> getTopRatedMovies(
            @Query("page") Integer page,
            @Query("language") String language
    );
}
