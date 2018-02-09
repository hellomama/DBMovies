package com.tony.dbmovie.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tony.dbmovie.R;

/**
 * Created by dev on 2/9/18.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView left,right;

    public HeaderViewHolder(View itemView) {
        super(itemView);

        left = itemView.findViewById(R.id.text_left);
        right = itemView.findViewById(R.id.text_right);
    }

}
