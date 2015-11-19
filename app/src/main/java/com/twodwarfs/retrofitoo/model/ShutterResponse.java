package com.twodwarfs.retrofitoo.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

import java.util.ArrayList;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * General Response object. Holds everything returned from basic API call.
 */
public class ShutterResponse extends BaseModel {

    @SerializedName(Fields.PAGE)
    private int mPage;

    @SerializedName(Fields.TOTAL_COUNT)
    private int mTotalCount;

    @SerializedName(Fields.DATA)
    private ArrayList<Image> mImages;

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public int getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        mTotalCount = totalCount;
    }

    public ArrayList<Image> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<Image> images) {
        mImages = images;
    }

    public static ShutterResponse fromJson(String json) {
        return new Gson().fromJson(json, ShutterResponse.class);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
