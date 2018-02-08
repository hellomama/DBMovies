package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.widget.ExpandTextView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/7/18.
 */

public class DetailSummaryBinder extends ItemViewBinder<MovieDetail, DetailSummaryBinder.DetailSummaryHolder> {

    static class DetailSummaryHolder extends RecyclerView.ViewHolder
    {
        ExpandTextView textView;
        public DetailSummaryHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.expand_text);
        }
    }

    @NonNull
    @Override
    protected DetailSummaryHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_summary,parent,false);
        return new DetailSummaryHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DetailSummaryHolder holder, @NonNull MovieDetail item) {
        holder.textView.initContent(item.getSummary());
    }
}
