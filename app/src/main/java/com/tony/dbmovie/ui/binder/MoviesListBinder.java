package com.tony.dbmovie.ui.binder;

import android.app.Activity;
import android.app.ActivityOptions;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Cast;
import com.tony.dbmovie.data.Director;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.ui.activity.DetailActivity;

import java.util.List;
import java.util.Locale;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/1/18.
 */

public class MoviesListBinder extends ItemViewBinder<Movie, MoviesListBinder.MoviesViewHolder>{

    private final static String FORMAT = "%s%s";
    private Activity context;

    static class MoviesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView poster;
        TextView title,director,cast,ratingPoint;
        RatingBar ratingBar;
        Movie movie;
        public MoviesViewHolder(View itemView, final Activity context) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_poster);
            title = itemView.findViewById(R.id.text_title);
            director = itemView.findViewById(R.id.text_director);
            cast = itemView.findViewById(R.id.text_cast);
            ratingPoint = itemView.findViewById(R.id.text_rating_point);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(context, poster, "poster");
                    DetailActivity.start(context,movie,options);

                }
            });
        }

        public void setup(@NonNull Movie item, @NonNull Bitmap bitmap)
        {
            Palette.Builder builder = new Palette.Builder(bitmap);
            Palette palette = builder.generate();
            if (palette.getLightMutedSwatch() != null) {
                item.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
            }else if (palette.getLightVibrantSwatch() != null){
                item.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
            }else if (palette.getDarkVibrantSwatch() != null)
            {
                item.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
            }

            movie = item;
        }
    }

    public MoviesListBinder(Activity context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected MoviesViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_movie,parent,false);
        return new MoviesViewHolder(view,context);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MoviesViewHolder holder, @NonNull final Movie item) {
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(item.getRating().getAverage()))/2);
        holder.ratingPoint.setText(String.valueOf(item.getRating().getAverage()));
        holder.title.setText(item.getTitle());
        holder.director.setText(formatDirector(item.getDirectors()));
        holder.cast.setText(formatCast(item.getCasts()));
        Glide.with(holder.poster.getContext()).load(item.getImages().getMedium()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.poster.setImageBitmap(resource);
                holder.setup(item,resource);
            }
        });
    }

    @Override
    protected boolean onFailedToRecycleView(@NonNull MoviesViewHolder holder) {
        return super.onFailedToRecycleView(holder);
    }

    private String formatDirector(List<Director> directors)
    {
        StringBuilder name = new StringBuilder();
        for (Director director : directors)
        {
            name.append(director.getName());
            name.append(" ");
        }
        return String.format(Locale.getDefault(),FORMAT,"导演：",name);
    }

    private String formatCast(List<Cast> casts)
    {
        StringBuilder name = new StringBuilder();
        for (Cast cast : casts)
        {
            name.append(cast.getName());
            name.append(" ");
        }
        return String.format(Locale.getDefault(),FORMAT,"主演：",name);
    }
}
