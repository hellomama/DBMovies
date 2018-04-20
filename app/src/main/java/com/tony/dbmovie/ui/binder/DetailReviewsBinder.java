package com.tony.dbmovie.ui.binder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.data.PopularComment;
import com.tony.dbmovie.ui.activity.CommentDetailActivity;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/8/18.
 */

public class DetailReviewsBinder extends ItemViewBinder<PopularComment,DetailReviewsBinder.ReviewsViewHolder>{

    static class ReviewsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView avatar;
        TextView userName,review_content,review_date,review_like;
        RatingBar ratingBar;
        ConstraintLayout parent;
        public ReviewsViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.img_avatar);
            userName = itemView.findViewById(R.id.text_user_name);
            review_content = itemView.findViewById(R.id.text_review_content);
            review_date = itemView.findViewById(R.id.text_date);
            review_like = itemView.findViewById(R.id.text_like);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            parent = itemView.findViewById(R.id.layout_parent);
        }
    }


    @NonNull
    @Override
    protected ReviewsViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_review,parent,false);
        return new ReviewsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ReviewsViewHolder holder, @NonNull final PopularComment item) {
        holder.review_content.setText(item.getContent());
        holder.userName.setText(item.getAuthor().getName());
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(item.getRating().getValue())));
        holder.review_like.setText(String.valueOf(item.getUsefulCount()));
        holder.review_date.setText(item.getCreatedAt());
        Glide.with(holder.avatar.getContext())
                .load(item.getAuthor().getAvatar())
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(holder.avatar) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(holder.avatar.getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.avatar.setImageDrawable(circularBitmapDrawable);
            }
        });

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("popular comment",item.toString());
                CommentDetailActivity.start(holder.parent.getContext(),item.getSubjectId());
            }
        });
    }
}
