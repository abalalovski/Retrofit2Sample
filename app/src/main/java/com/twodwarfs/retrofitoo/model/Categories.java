package com.twodwarfs.retrofitoo.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * Categories container.
 */
public class Categories extends BaseModel {

    @SerializedName(Fields.DATA)
    private List<Category> mCategories = new ArrayList<>();

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public static Categories fromJson(String json) {
        return new Gson().fromJson(json, Categories.class);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
