package com.twodwarfs.retrofitoo.net;

import com.twodwarfs.retrofitoo.model.ShutterResponse;

import retrofit.Call;

public interface ApiMethods {

    Call<ShutterResponse> getPhotos();

}
