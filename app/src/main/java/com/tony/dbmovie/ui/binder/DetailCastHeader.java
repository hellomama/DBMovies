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
 * Created by dev on 2/9/18.
 */

public class DetailCastHeader extends ItemViewBinder<EmptyClass,DetailCastHeader.CastHeaderViewHolder> {


    static class CastHeaderViewHolder extends RecyclerView.ViewHolder
    {
        public CastHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    protected DetailCastHeader.CastHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_cast_title,parent,false);
        return new CastHeaderViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DetailCastHeader.CastHeaderViewHolder holder, @NonNull EmptyClass item) {

    }
}
