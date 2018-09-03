package com.example.xback.simpleandroid.networking;

import rx.Subscription;

public class Service {
    private final NetworkService networkService;

    public Service (NetworkService networkService){
        this.networkService = networkService;
    }

//    getting city list
    public Subscription getCityList (final GetCityListCallBack callBack){
        return networkService.getListCity()
    }

    public interface GetCityListCallBack{
        void
    }
}
