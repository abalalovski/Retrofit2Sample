package com.twodwarfs.retrofitoo.model;

import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * Asset object representation.
 */

public class Asset extends BaseModel {

    @SerializedName(Fields.WIDTH)
    private int mWidth;

    @SerializedName(Fields.HEIGHT)
    private int mHeight;

    @SerializedName(Fields.URL)
    private String mUrl;

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}