package com.myrep.rals.tehcnicianapps.service;


import com.myrep.rals.tehcnicianapps.model.LogStatus;
import com.myrep.rals.tehcnicianapps.model.PersonalData;
import com.myrep.rals.tehcnicianapps.model.PersonalInfo;
import com.myrep.rals.tehcnicianapps.model.WorkOrders;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Pinjaman on 1/22/2018.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("Login")
    Call<LogStatus> postLogin(@Field("email") String email, @Field("password") String password);

    @POST("Logout")
    Call<LogStatus> postLogout();

    @GET("GetPersonalInfo")
    Call<PersonalData> getPersonalInfo(@Header("Authorization") String bearer);

    @GET("GetWorkOrders")
    Call<WorkOrders> getWorkOrders(@Header("Authorization") String bearer);


}
