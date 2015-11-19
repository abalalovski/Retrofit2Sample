package com.twodwarfs.retrofitoo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twodwarfs.retrofitoo.R;
import com.twodwarfs.retrofitoo.model.Image;
import com.twodwarfs.retrofitoo.model.ShutterResponse;
import com.twodwarfs.retrofitoo.net.ShutterApi;
import com.twodwarfs.retrofitoo.ui.adapters.ImagesAdapter;
import com.twodwarfs.retrofitoo.utils.Logger;
import com.twodwarfs.retrofitoo.utils.Utils;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Aleksandar Balalovski
 * <p>
 * Main Fragment, all logics is here.
 */

public class MainFragment extends Fragment {

    private static final String CATEGORIES = "categories";

    private RecyclerView mRecyclerView;
    private ImagesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        setHasOptionsMenu(true);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_images);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ImagesAdapter();
        mAdapter.setOnItemClickListener(new ImagesAdapter.IOnItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                Image image = (Image) mAdapter.getItem(position);
                if (image != null) {
                    Utils.doToast(getActivity(), image.getDesc());
                }
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        if (Utils.hasActiveNetworkConnection(getActivity())) {
            Call<ShutterResponse> call = ShutterApi.getInstance().getPhotos();
            call.enqueue(new Callback<ShutterResponse>() {
                @Override
                public void onResponse(Response<ShutterResponse> response, Retrofit retrofit) {
                    ShutterResponse body = response.body();
                    if (body != null) {
                        mAdapter.setImages(body.getImages());
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Logger.doLogException(t);
                }
            });
        } else {
            Utils.doToast(getActivity(), getString(R.string.no_connectivity));
        }

        return rootView;
    }
}
