package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Photo;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;
import com.tony.dbmovie.ui.activity.PhotoActivity;
import com.tony.dbmovie.ui.adapter.PhotoAdapter;
import com.tony.dbmovie.widget.CommonDecoration;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 3/29/18.
 */

public class CelebrityPhotosBinder extends ItemViewBinder<PhotoResult,CelebrityPhotosBinder.PhotoHolder> {

    private final static String FORMAT = "全部%1$s张影人照片";


    @NonNull
    @Override
    protected PhotoHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_celebrity_photo,parent,false);
        return new PhotoHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull PhotoHolder holder, @NonNull final PhotoResult item) {
        holder.photoCount.setText(String.format(FORMAT,item.getCount()));
        holder.photoCount.setVisibility(item.getCount()>10?View.VISIBLE:View.GONE);
        holder.setList(item.getPhotos());
        holder.photoCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoActivity.start(v.getContext(),item,null);
            }
        });
    }

    static class PhotoHolder extends RecyclerView.ViewHolder
    {
        RecyclerView recyclerView;
        TextView photoCount;
        PhotoAdapter adapter;
        public PhotoHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.photo_list);
            photoCount = itemView.findViewById(R.id.photo_count);
            adapter = new PhotoAdapter(itemView.getContext(),false);
            recyclerView.addItemDecoration(new CommonDecoration(itemView.getContext(),R.drawable.vertical_decoration, LinearLayoutManager.HORIZONTAL));
            recyclerView.setAdapter(adapter);
        }
        public void setList(List<Photo> photos)
        {
            adapter.setPhotos(photos);
            adapter.notifyDataSetChanged();
        }

    }
}
