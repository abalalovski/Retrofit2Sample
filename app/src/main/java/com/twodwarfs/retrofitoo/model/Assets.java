package com.twodwarfs.retrofitoo.model;

import com.google.gson.annotations.SerializedName;
import com.twodwarfs.retrofitoo.cons.Fields;

/**
 * Created by Aleksandar Balalovski on 19.11.15.
 *
 * Assets container.
 */
public class Assets extends BaseModel {

    @SerializedName(Fields.PREVIEW)
    private Asset mPreview;

    @SerializedName(Fields.SMALL_THUMB)
    private Asset mSmallThumb;

    public Asset getPreview() {
        return mPreview;
    }

    public void setPreview(Asset preview) {
        mPreview = preview;
    }

    public Asset getSmallThumb() {
        return mSmallThumb;
    }

    public void setSmallThumb(Asset smallThumb) {
        mSmallThumb = smallThumb;
    }

}
