package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.data.MovieDetail;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/8/18.
 */

public class DetailCastBinder extends ItemViewBinder<MovieDetail,DetailCastBinder.CastViewHolder>{

    static class CastViewHolder extends RecyclerView.ViewHolder
    {
        public CastViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    protected CastViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return null;
    }

    @Override
    protected void onBindViewHolder(@NonNull CastViewHolder holder, @NonNull MovieDetail item) {

    }
}
