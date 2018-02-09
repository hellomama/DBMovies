package com.tony.dbmovie.ui;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Cast;

import java.util.Collections;
import java.util.List;

/**
 * Created by dev on 2/9/18.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private List<Cast> casts = Collections.emptyList();


    public void setCasts(@Nullable List<Cast> castList)
    {
        casts = castList;
    }

    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast_view,parent,false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {
        Cast cast = casts.get(position);
        Glide.with(holder.avatar.getContext()).load(cast.getAvatars().getMedium()).into(holder.avatar);
        holder.textView.setText(cast.getName());
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder
    {
        ImageView avatar;
        TextView textView;
        private CastViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.img_avatar);
            textView = itemView.findViewById(R.id.text_name);
        }
    }
}
