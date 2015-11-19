package com.twodwarfs.retrofitoo;

import junit.framework.Assert;

import static org.junit.Assert.*;

/**
 * Api Test, I don't know what other can be tested in this sort of app
 */

public class ApiTest {

    public void testApiObject() {
        Call<ShutterResponse> call = ShutterApi.getInstance().getPhotos();
        assertNotNull(call);
    }

    public void testApiRequestNotNull() {
        Call<ShutterResponse> call = ShutterApi.getInstance().getPhotos();
        call.enqueue(new Callback<ShutterResponse>() {
            @Override
            public void onResponse(Response<ShutterResponse> response, Retrofit retrofit) {
                ShutterResponse body = response.body();
                assertThat(body, is(not(null)));
            }

            @Override
            public void onFailure(Throwable t) {
                Logger.doLogException(t);
                Assert.fail("Failed request to server");
            }
        });
    }

    public void testApiRequestNotEmpty() {
        Call<ShutterResponse> call = ShutterApi.getInstance().getPhotos();
        call.enqueue(new Callback<ShutterResponse>() {
            @Override
            public void onResponse(Response<ShutterResponse> response, Retrofit retrofit) {
                ShutterResponse body = response.body();
                assertThat(body.getImages(), is(not(0)));
            }

            @Override
            public void onFailure(Throwable t) {
                Logger.doLogException(t);
                Assert.fail("Failed request to server");
            }
        });
    }
}