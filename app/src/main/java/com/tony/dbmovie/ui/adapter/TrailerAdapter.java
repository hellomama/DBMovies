package com.tony.dbmovie.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Photo;
import com.tony.dbmovie.data.Trailer;
import com.tony.dbmovie.ui.activity.TrailerActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by dev on 2/9/18.
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {
    private List<Object> casts = Collections.emptyList();


    public void setCasts(@Nullable List<Object> castList)
    {
        casts = castList;
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trailer_view,parent,false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TrailerViewHolder holder, int position) {
        Object o = casts.get(position);
        if (o instanceof Trailer)
        {
            final Trailer trailer = (Trailer)o;
            Glide.with(holder.background.getContext()).load(trailer.getMedium()).into(holder.background);
            holder.play.setVisibility(View.VISIBLE);
            holder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TrailerActivity.startActivity(holder.play.getContext(),trailer);
                }
            });
        }else if (o instanceof Photo)
        {
            Photo photo = (Photo)o;
            Glide.with(holder.background.getContext()).load(photo.getCover()).into(holder.background);
            holder.play.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    static class TrailerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView background,play;
        private TrailerViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.img_trailer);
            play = itemView.findViewById(R.id.img_play);
        }
    }
}
