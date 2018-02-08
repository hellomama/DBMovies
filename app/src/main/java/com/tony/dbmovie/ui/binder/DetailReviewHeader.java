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
 * Created by dev on 2/8/18.
 */

public class DetailReviewHeader extends ItemViewBinder<EmptyClass,DetailReviewHeader.ReviewHeaderViewHolder>{

    static class ReviewHeaderViewHolder extends RecyclerView.ViewHolder
    {
        public ReviewHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    protected ReviewHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_reivew_title,parent,false);
        return new ReviewHeaderViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ReviewHeaderViewHolder holder, @NonNull EmptyClass item) {

    }
}
