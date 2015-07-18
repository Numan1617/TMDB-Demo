package com.numan1617.api;

import com.numan1617.api.model.Movie;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import rx.Observable;

/**
 * Created by jamesnewman on 18/07/15.
 */
public class MockMovieService implements MovieService {

    private final Converter converter;

    public MockMovieService(Converter converter) {
        this.converter = converter;
    }

    @Override
    public Observable<Movie> getMovieById(int id, String language) {
        String payload = "{\n" +
                "  \"adult\": false,\n" +
                "  \"backdrop_path\": \"/hNFMawyNDWZKKHU4GYCBz1krsRM.jpg\",\n" +
                "  \"belongs_to_collection\": null,\n" +
                "  \"budget\": 63000000,\n" +
                "  \"genres\": [\n" +
                "    {\n" +
                "      \"id\": 18,\n" +
                "      \"name\": \"Drama\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"homepage\": \"\",\n" +
                "  \"id\": 550,\n" +
                "  \"imdb_id\": \"tt0137523\",\n" +
                "  \"original_language\": \"en\",\n" +
                "  \"original_title\": \"Fight Club\",\n" +
                "  \"overview\": \"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.\",\n" +
                "  \"popularity\": 2.50307202280779,\n" +
                "  \"poster_path\": \"/2lECpi35Hnbpa4y46JX0aY3AWTy.jpg\",\n" +
                "  \"production_companies\": [\n" +
                "    {\n" +
                "      \"name\": \"20th Century Fox\",\n" +
                "      \"id\": 25\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Fox 2000 Pictures\",\n" +
                "      \"id\": 711\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Regency Enterprises\",\n" +
                "      \"id\": 508\n" +
                "    }\n" +
                "  ],\n" +
                "  \"production_countries\": [\n" +
                "    {\n" +
                "      \"iso_3166_1\": \"DE\",\n" +
                "      \"name\": \"Germany\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"iso_3166_1\": \"US\",\n" +
                "      \"name\": \"United States of America\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"release_date\": \"1999-10-14\",\n" +
                "  \"revenue\": 100853753,\n" +
                "  \"runtime\": 139,\n" +
                "  \"spoken_languages\": [\n" +
                "    {\n" +
                "      \"iso_639_1\": \"en\",\n" +
                "      \"name\": \"English\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"Released\",\n" +
                "  \"tagline\": \"How much can you know about yourself if you've never been in a fight?\",\n" +
                "  \"title\": \"Fight Club\",\n" +
                "  \"video\": false,\n" +
                "  \"vote_average\": 7.7,\n" +
                "  \"vote_count\": 3185\n" +
                "}";

        try {
            TypedInput input = new TypedByteArray("application/json", payload.getBytes());
            Movie movie = (Movie) this.converter.fromBody(input, Movie.class);

            return Observable.just(movie);
        } catch (ConversionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
