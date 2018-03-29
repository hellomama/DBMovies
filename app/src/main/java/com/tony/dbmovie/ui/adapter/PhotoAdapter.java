package com.tony.dbmovie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Photo;
import com.tony.dbmovie.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private List<Photo> photoList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;
    private boolean isAll;

    public PhotoAdapter(Context context,boolean isAllPhoto) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        isAll = isAllPhoto;
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
        return new PhotoHolder(view,isAll);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoHolder holder, int position) {
        Photo photo = photoList.get(position);
        Glide.with(context).load(photo.getCover()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (isAll)
        {
            return photoList.size();
        }else {
            return photoList.size() > 10 ? 10 : photoList.size();
        }
    }

    static class PhotoHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public PhotoHolder(View itemView,boolean isAllPhoto) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_photo);

            if (isAllPhoto) {
                int screenWidth = Utils.screenWidth();
                int padding = Utils.dimenToPixel(R.dimen.photo_padding);
                int size = (screenWidth - padding * 4) * 3 / 10;

                LinearLayout.LayoutParams imageParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                if (imageParams != null) {
                    imageParams.width = size;
                    imageParams.height = size;

                    imageView.setLayoutParams(imageParams);
                }
            }
        }
    }
}
