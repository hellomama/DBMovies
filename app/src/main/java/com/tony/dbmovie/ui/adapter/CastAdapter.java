package com.tony.dbmovie.ui.adapter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.BaseData;
import com.tony.dbmovie.data.Cast;
import com.tony.dbmovie.data.Director;
import com.tony.dbmovie.ui.activity.CelebrityActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by dev on 2/9/18.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private List<Object> casts = Collections.emptyList();


    public void setCasts(@Nullable List<Object> castList)
    {
        casts = castList;
    }

    @Override
    public CastAdapter.CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast_view,parent,false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CastViewHolder holder, int position) {
        final Object o = casts.get(position);
        if (o instanceof Cast)
        {
            final Cast cast = (Cast)o;
            holder.textView.setText(cast.getName());
            Glide.with(holder.avatar.getContext()).load(cast.getAvatars().getMedium()).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    holder.avatar.setImageBitmap(resource);
                    holder.setup(cast,resource);
                }
            });
        }else if (o instanceof Director)
        {
            final Director director = (Director)o;
            holder.textView.setText("导演："+director.getName());
            Glide.with(holder.avatar.getContext()).load(director.getAvatars().getMedium()).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    holder.avatar.setImageBitmap(resource);
                    holder.setup(director,resource);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder
    {
        ImageView avatar;
        TextView textView;
        BaseData data;
        private CastViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.img_avatar);
            textView = itemView.findViewById(R.id.text_name);
            avatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (data instanceof Cast)
                    {
                        CelebrityActivity.start(view.getContext(),(Cast)data,null);
                    }else if (data instanceof Director)
                    {
                        CelebrityActivity.start(view.getContext(),(Director) data,null);
                    }
                }
            });
        }
        private void setup(@NonNull BaseData item, @NonNull Bitmap bitmap)
        {
            Palette.Builder builder = new Palette.Builder(bitmap);
            Palette palette = builder.generate();
            if (palette.getDarkVibrantSwatch() != null) {
                item.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
            }else if (palette.getLightVibrantSwatch() != null){
                item.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
            }else if (palette.getLightMutedSwatch() != null)
            {
                item.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
            }
            data = item;
        }
    }
}
