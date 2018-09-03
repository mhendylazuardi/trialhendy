package com.example.xback.simpleandroid.networking;

import com.example.xback.simpleandroid.models.CityListResponse;

import java.util.Observable;

import retrofit2.http.GET;

public interface NetworkService {
    @GET("v1/city")
    Observable<CityListResponse> getCityList();
}
