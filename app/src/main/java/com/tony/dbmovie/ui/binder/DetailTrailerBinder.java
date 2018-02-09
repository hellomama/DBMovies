package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.ui.adapter.CastAdapter;
import com.tony.dbmovie.ui.adapter.TrailerAdapter;
import com.tony.dbmovie.widget.CommonDecoration;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/9/18.
 */

public class DetailTrailerBinder extends ItemViewBinder<MovieDetail,DetailTrailerBinder.TrailerViewHolder>{
    static class TrailerViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView recyclerView ;
        TrailerAdapter adapter;
        public TrailerViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.list_cast);
            recyclerView.addItemDecoration(new CommonDecoration(itemView.getContext(),R.drawable.vertical_decoration, LinearLayoutManager.VERTICAL));
            adapter = new TrailerAdapter();
            recyclerView.setAdapter(adapter);
        }

        public void setList(List<Object> casts)
        {
            adapter.setCasts(casts);
            adapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    protected TrailerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_cast,parent,false);
        return new TrailerViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TrailerViewHolder holder, @NonNull MovieDetail item) {
        List<Object> data = new ArrayList<>();
        data.add(item.getTrailers().get(0));
        if (item.getPhotos().size()>9) {
            for (int i = 0; i < 8; i++) {
                data.add(item.getPhotos().get(i));
            }
        }else {
            data.addAll(item.getPhotos());
        }
        holder.setList(data);
    }
}
