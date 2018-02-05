package com.tony.dbmovie.view.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.data.Movie;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by bushi on 2018/2/3.
 */

public class MovieDetailHeader extends ItemViewBinder<Movie, MovieDetailHeader.HeaderViewHolder> {

    static class HeaderViewHolder extends RecyclerView.ViewHolder
    {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    protected HeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return null;
    }

    @Override
    protected void onBindViewHolder(@NonNull HeaderViewHolder holder, @NonNull Movie item) {

    }
}
