package com.twodwarfs.retrofitoo.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twodwarfs.retrofitoo.R;
import com.twodwarfs.retrofitoo.model.BaseModel;
import com.twodwarfs.retrofitoo.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandar Balalovski
 * <p/>
 * Images Adapter class that implements the logics of multi-type RecyclerView Adapter.
 * The logics is pretty clear, the only thing I find disturbing is that the
 * Search functionality will not work perfectly, it will just give you hint on the idea
 * how I intended to implement it.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    /**
     * Main holder of all data
     **/
    private List<Image> mData = new ArrayList();

    /**
     * Initial unmodified data that serves as helper
     **/
    private Context mContext;

    /**
     * My implementation of OnItemClickListener interface.
     * In our case we don't need this.
     */
    public interface IOnItemClick {
        void onItemClick(View v, int position);
    }

    static IOnItemClick mOnItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public View mRootView;

        public ViewHolder(View v) {
            super(v);
            mRootView = v;
            mRootView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getPosition());
            }
        }
    }

    public ImagesAdapter() {
    }

    public void setOnItemClickListener(IOnItemClick listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.image_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image image = mData.get(position);
        ImageView imageView = (ImageView) holder.mRootView.findViewById(R.id.imageView_image);
        TextView textViewDescription = (TextView) holder.mRootView.findViewById(R.id.textView_description);
        textViewDescription.setText(image.getDesc());

        /** download the image for this position item **/
        Glide.with(mContext)
                .load(image.getAssets().getSmallThumb().getUrl())
                .into(imageView);
    }

    public BaseModel getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setImages(List<Image> images) {
        mData = images;
        notifyDataSetChanged();
    }
}
