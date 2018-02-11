package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Trailer;
import com.tony.dbmovie.widget.IjkPlayerView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/11/18.
 */

public class TrailerDetailBinder extends ItemViewBinder<Trailer,TrailerDetailBinder.TrailerDetailViewHolder>{

    static class TrailerDetailViewHolder extends RecyclerView.ViewHolder
    {

        IjkPlayerView playerView;
        ImageView play;
        public TrailerDetailViewHolder(View itemView) {
            super(itemView);
            playerView = itemView.findViewById(R.id.player);
            play = itemView.findViewById(R.id.img_play);

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerView.start();
                }
            });
        }
    }

    @NonNull
    @Override
    protected TrailerDetailViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.trailer_detail_header,parent,false);
        return new TrailerDetailViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TrailerDetailViewHolder holder, @NonNull Trailer item) {
        holder.playerView.setVideoPath(item.getResourceUrl());
    }
}
