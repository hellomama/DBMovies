package com.tony.dbmovie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private List<Photo> photoList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public PhotoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setPhotos(List<Photo> photos)
    {
        photoList.clear();
        if (photos != null)
        {
            photoList.addAll(photos);
        }
    }

    @Override
    public PhotoAdapter.PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_photo,parent,false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoHolder holder, int position) {
        Photo photo = photoList.get(position);
        Glide.with(context).load(photo.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return photoList.size()>10?10:photoList.size();
    }

    static class PhotoHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public PhotoHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_photo);
        }
    }
}
