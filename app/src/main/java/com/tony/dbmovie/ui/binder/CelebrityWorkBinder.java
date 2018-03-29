package com.tony.dbmovie.ui.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.WorkResult;
import com.tony.dbmovie.ui.adapter.WorkAdapter;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by dev on 3/29/18.
 */

public class CelebrityWorkBinder extends ItemViewBinder<WorkResult,CelebrityWorkBinder.CelebrityWorkHolder> {

    private final static String FORMAT = "全部%1$s部电影作品";

    @NonNull
    @Override
    protected CelebrityWorkHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_celevrity_work,parent,false);
        return new CelebrityWorkHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull CelebrityWorkHolder holder, @NonNull WorkResult item) {
        holder.workCount.setVisibility(item.getCount()>5?View.VISIBLE:View.GONE);
        holder.workCount.setText(String.format(FORMAT,item.getWorks().size()));
        holder.adapter.setWorkList(item.getWorks());
    }

    static class CelebrityWorkHolder extends RecyclerView.ViewHolder
    {
        RecyclerView listView;
        TextView workCount;
        WorkAdapter adapter;
        public CelebrityWorkHolder(View itemView) {
            super(itemView);
            listView = itemView.findViewById(R.id.work_list);
            workCount = itemView.findViewById(R.id.work_count);
            adapter = new WorkAdapter(itemView.getContext());
            listView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            listView.setAdapter(adapter);
        }

        public WorkAdapter getAdapter()
        {
            return adapter;
        }
    }
}
