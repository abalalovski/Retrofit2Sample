package com.twodwarfs.retrofitoo.net;

import android.util.Base64;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.twodwarfs.retrofitoo.cons.Constants;
import com.twodwarfs.retrofitoo.model.ShutterResponse;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ShutterApi implements ApiMethods {
    private static ShutterApi mInstance;
    private IApiService mApiService;

    private IApiService getApi() {
        if (mApiService == null) {

            OkHttpClient client = new OkHttpClient();
            LoggingInterceptor logging = new LoggingInterceptor();
            client.interceptors().add(mInterceptor);
            client.interceptors().add(logging);

            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiService = restAdapter.create(IApiService.class);
        }
        return mApiService;
    }

    public static ShutterApi getInstance() {
        return mInstance == null ? (mInstance = new ShutterApi()) : mInstance;
    }

    private String buildBasicAuthorizationString(String username, String password) {
        String credentials = username + ":" + password;
        return "Basic " + new String(Base64.encode(credentials.getBytes(), Base64.NO_WRAP));
    }


    private Interceptor mInterceptor = new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            String basic = buildBasicAuthorizationString(Constants.CLIENT_ID,
                    Constants.CLIENT_SECRET);

            Request request = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Authorization", basic)
                    .method(original.method(), original.body())
                    .build();

            Response response = chain.proceed(request);

            return response;
        }
    };

    @Override
    public Call<ShutterResponse> getPhotos() {
        return getApi().getPhotos();
    }
}
