package com.numan1617.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.numan1617.tmdb.api.BuildConfig;
import com.squareup.okhttp.OkHttpClient;

import org.joda.time.DateTime;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by jamesnewman on 18/07/15.
 */
@Module
public class ApiModule {

    @Provides
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint("https://api.themoviedb.org/3");
    }

    @Provides
    DateTimeTypeConverter provideDateTimeTypeConverter() {
        return new DateTimeTypeConverter();
    }

    @Provides
    Converter provideConverter(DateTimeTypeConverter dateTimeTypeConverter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, dateTimeTypeConverter)
                .create();
        return new GsonConverter(gson);
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides
    RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor() {
            public void intercept(RequestFacade requestFacade) {
                requestFacade.addQueryParam("api_key", BuildConfig.TMDB_API_KEY);
            }
        };
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, Client client, RestAdapter.LogLevel logLevel, Converter converter, RequestInterceptor requestInterceptor) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setEndpoint(endpoint)
                .setLogLevel(logLevel)
                .setConverter(converter)
                .setRequestInterceptor(requestInterceptor)
                .build();
    }
}
