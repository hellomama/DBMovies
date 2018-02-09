package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Cast;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.ui.CastAdapter;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/8/18.
 */

public class DetailCastBinder extends ItemViewBinder<MovieDetail,DetailCastBinder.CastViewHolder>{

    static class CastViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView recyclerView ;
        CastAdapter adapter;
        public CastViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.list_cast);
            DividerItemDecoration decor = new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.HORIZONTAL);
            recyclerView.addItemDecoration(decor);
            adapter = new CastAdapter();
            recyclerView.setAdapter(adapter);
        }

        public void setList(List<Cast> casts)
        {
            adapter.setCasts(casts);
            adapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    protected CastViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_cast,parent,false);
        return new CastViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull CastViewHolder holder, @NonNull MovieDetail item) {
        holder.setList(item.getCasts());
    }
}
