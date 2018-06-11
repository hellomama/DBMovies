package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.widget.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 4/20/18.
 */

public class DetailTagsBinder extends ItemViewBinder<MovieDetail,DetailTagsBinder.TagsHolder> {
    @NonNull
    @Override
    protected DetailTagsBinder.TagsHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_tags,parent,false);
        return new TagsHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DetailTagsBinder.TagsHolder holder, @NonNull MovieDetail item) {
        List<String> tags = item.getTags();
        for (String tag:tags)
        {
            View layout = View.inflate(holder.layout.getContext(), R.layout.item_tag_string, null);
            holder.layout.addView(layout);
            TextView tagText = layout.findViewById(R.id.text_tag);
            tagText.setText(tag);
        }
    }

    static class TagsHolder extends RecyclerView.ViewHolder
    {
        FlowLayout layout;
        public TagsHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.flow_layout);
        }
    }
}

