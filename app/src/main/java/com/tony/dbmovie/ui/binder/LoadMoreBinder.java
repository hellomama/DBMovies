package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.EmptyClass;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by bushi on 2018/2/5.
 */

public class LoadMoreBinder extends ItemViewBinder<EmptyClass,LoadMoreBinder.MoreViewHolder>{
    static class MoreViewHolder extends RecyclerView.ViewHolder
    {
        public MoreViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    protected MoreViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.more_view,parent,false);
        return new MoreViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MoreViewHolder holder, @NonNull EmptyClass item) {

    }
}
