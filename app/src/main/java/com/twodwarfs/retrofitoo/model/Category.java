package com.twodwarfs.retrofitoo.model;

import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * Category object representation.
 */
public class Category extends BaseModel {

    @SerializedName(Fields.ID)
    private String mId;

    @SerializedName(Fields.NAME)
    private String mName;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
