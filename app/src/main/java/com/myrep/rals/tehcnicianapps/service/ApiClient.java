package com.myrep.rals.tehcnicianapps.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pinjaman on 1/22/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://myrep.nagasakti.team/api/v2/Mobile/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
