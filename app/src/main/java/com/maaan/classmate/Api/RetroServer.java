package com.maaan.classmate.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static final String baseUrl = "http://10.0.2.2/classmate/";
    private static Retrofit retrofit;

    public static Retrofit konekRetrofit(){
        if (retrofit == null){
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
