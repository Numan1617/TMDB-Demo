package com.numan1617.api;

import com.numan1617.api.model.Movie;

import rx.Observer;

/**
 * Created by jamesnewman on 18/07/15.
 */
public class MovieTesterClass {

    public static void main(String[] args) {
        MovieService movieService = DaggerApiComponent.create().movieService();

        movieService.getMovieById(550, null)
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("getMovieById onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("getMovieById onError");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Movie movie) {
                        System.out.println("getMovieById onNext");
                    }
                });
    }
}
