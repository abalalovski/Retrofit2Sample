package com.twodwarfs.retrofitoo.model;

import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * Image object representation.
 */
public class Image extends BaseModel {

    @SerializedName(Fields.ID)
    private int mId;

    @SerializedName(Fields.ASSETS)
    private Assets mAssets;

    @SerializedName(Fields.DESC)
    private String mDescription;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public Assets getAssets() {
        return mAssets;
    }

    public void setAssets(Assets assets) {
        mAssets = assets;
    }

    public String getDesc() {
        return mDescription;
    }

    public void setDescription(String desc) {
        mDescription = desc;
    }
}
