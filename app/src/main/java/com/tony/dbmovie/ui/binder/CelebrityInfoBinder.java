package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.widget.ExpandTextView;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by bushi on 2018/3/25.
 */

public class CelebrityInfoBinder extends ItemViewBinder<Celebrity,CelebrityInfoBinder.CelebrityItemHolder> {


    @NonNull
    @Override
    protected CelebrityItemHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_celebrity_header,parent,false);
        return new CelebrityItemHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull CelebrityItemHolder holder, @NonNull Celebrity item) {
        holder.name.setText(item.getName());
        holder.name_en.setText(item.getNameEn());
        holder.birthday.setText(item.getBirthday());
        holder.home.setText(item.getBornPlace());
        holder.identify.setText(item.getDisplayProfessions());
        holder.expandTextView.initContent(item.getSummary());
        holder.layout.setBackgroundColor(item.getBackgroundColor());
        Glide.with(holder.imageView.getContext()).load(item.getAvatars().getMedium()).into(holder.imageView);
    }

    static class CelebrityItemHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,name_en,birthday,home,identify;
        ExpandTextView expandTextView;
        LinearLayout layout;
        public CelebrityItemHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_avatar);
            name = itemView.findViewById(R.id.text_name);
            name_en = itemView.findViewById(R.id.text_name_en);
            birthday = itemView.findViewById(R.id.text_birthday);
            home = itemView.findViewById(R.id.text_home);
            identify = itemView.findViewById(R.id.text_identity);
            expandTextView = itemView.findViewById(R.id.expand_text);
            layout = itemView.findViewById(R.id.layout_info);
        }
    }
}
