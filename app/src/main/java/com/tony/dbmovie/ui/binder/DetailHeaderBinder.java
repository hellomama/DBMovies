package com.tony.dbmovie.ui.binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.ui.activity.ReviewsActivity;
import com.tony.dbmovie.widget.RateLayout;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/6/18.
 */

public class DetailHeaderBinder extends ItemViewBinder<Movie,DetailHeaderBinder.DetailHeaderHolder> {

    static class DetailHeaderHolder extends RecyclerView.ViewHolder{

        ImageView poster;
        TextView text_name_cn,text_name_original,text_type,text_duration,text_date,text_total_comment,text_average;
        LinearLayout layout;
        RateLayout rateLayout;
        public DetailHeaderHolder(View view) {
            super(view);
            layout= view.findViewById(R.id.layout_detail_header);
            poster = view.findViewById(R.id.img_poster);
            text_name_cn = view.findViewById(R.id.text_name_cn);
            text_name_original = view.findViewById(R.id.text_name_en);
            text_type = view.findViewById(R.id.text_type);
            text_duration = view.findViewById(R.id.text_duration);
            text_date = view.findViewById(R.id.text_date);
            text_total_comment = view.findViewById(R.id.text_total_comment);
            text_average = view.findViewById(R.id.text_average);
            rateLayout = view.findViewById(R.id.rate_layout);

            text_average.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), ReviewsActivity.class));
                }
            });
        }
    }


    public DetailHeaderBinder() {
    }


    @NonNull
    @Override
    protected DetailHeaderBinder.DetailHeaderHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.movie_detail,parent,false);
        return new DetailHeaderHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DetailHeaderBinder.DetailHeaderHolder holder, @NonNull Movie item) {
        holder.layout.setBackgroundColor(item.getBackgroundColor());
        holder.text_average.setText(String.valueOf(item.getRating().getAverage()));
        holder.text_total_comment.setText(String.valueOf(item.getRating().getDetails().getTotal()));
        holder.text_date.setText(item.getMainlandPubdate()+" 在中国大陆上映");
        holder.text_name_cn.setText(item.getTitle());
        holder.text_name_original.setText(item.getOriginalTitle());
        holder.text_type.setText(getGenresFormat(item.getGenres()));
        holder.text_duration.setText(item.getDurations() == null ? " ":item.getDurations().get(0));
        Glide.with(holder.poster.getContext()).load(item.getImages().getMedium()).into(holder.poster);
        holder.rateLayout.setData(getRateList(item));
    }

    private String getGenresFormat(List<String> Genres)
    {
       StringBuilder builder = new StringBuilder();
       for (String genre : Genres)
       {
           builder.append(genre);
           builder.append(" ");
       }
       return builder.toString();
    }

    private List<Double> getRateList(Movie item)
    {
        List<Double> result = new ArrayList<>();
        result.add(item.getRating().getDetails().get1());
        result.add(item.getRating().getDetails().get2());
        result.add(item.getRating().getDetails().get3());
        result.add(item.getRating().getDetails().get4());
        result.add(item.getRating().getDetails().get5());
        return result;
    }
}
