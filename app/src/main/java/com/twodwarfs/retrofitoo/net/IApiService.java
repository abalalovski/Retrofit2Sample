package com.twodwarfs.retrofitoo.net;

import com.twodwarfs.retrofitoo.model.ShutterResponse;

import retrofit.Call;
import retrofit.http.GET;

public interface IApiService {

    @GET("/v2/images/search")
    Call<ShutterResponse> getPhotos();

}
