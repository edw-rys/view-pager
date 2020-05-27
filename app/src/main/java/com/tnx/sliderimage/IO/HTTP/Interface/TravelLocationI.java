package com.tnx.sliderimage.IO.HTTP.Interface;

import com.tnx.sliderimage.IO.HTTP.Connection;
import com.tnx.sliderimage.IO.Models.SimpleModelResquest;
import com.tnx.sliderimage.IO.Models.TravelLocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TravelLocationI {
    @GET(Connection.URL_TRAVEL)
    Call<List<TravelLocation>> getAll();

    @GET(Connection.URL_TRAVEL)
    Call<List<TravelLocation>> getByUser(@Query("id") int id);

    @FormUrlEncoded
    @POST(Connection.URL_TRAVEL+"/add")
    Call<SimpleModelResquest> add(
            @Field("title")     String status_active,
            @Field("location")       String description,
            @Field("imageUrl")       String observacion
    );

    @GET(Connection.URL_TRAVEL)
    Call<List<TravelLocation>> delete(@Query("id") int id);

    @FormUrlEncoded
    @POST(Connection.URL_TRAVEL+"/update")
    Call<SimpleModelResquest> update(
            @Field("title")     String status_active,
            @Field("location")       String description,
            @Field("imageUrl")       String observacion
    );
}
