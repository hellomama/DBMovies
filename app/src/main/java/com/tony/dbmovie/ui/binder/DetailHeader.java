package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.EmptyClass;
import com.tony.dbmovie.ui.HeaderViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 2/8/18.
 */

public class DetailHeader extends ItemViewBinder<EmptyClass,HeaderViewHolder>{

    @NonNull
    @Override
    protected HeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_title,parent,false);
        return new HeaderViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull HeaderViewHolder holder, @NonNull EmptyClass item) {
        String left = item.getLeftString();
        String right = item.getRightString();

        setupView(holder.left,left);
        setupView(holder.right,right);
    }

    private void setupView(TextView view, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            view.setVisibility(View.INVISIBLE);
        }else {
            view.setVisibility(View.VISIBLE);
            view.setText(s);
        }
    }
}
