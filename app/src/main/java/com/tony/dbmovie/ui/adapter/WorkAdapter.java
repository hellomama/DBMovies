package com.tony.dbmovie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkHolder> {
    private LayoutInflater inflater;
    private List<Work> workList = new ArrayList<>();
    private Context context;

    public WorkAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setWorkList(List<Work> works)
    {
        workList.clear();
        if (works != null)
        {
            workList.addAll(works);
        }
        notifyDataSetChanged();
    }

    @Override
    public WorkAdapter.WorkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_work,parent,false);
        return new WorkHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkAdapter.WorkHolder holder, int position) {
        Work work = workList.get(position);
        holder.workName.setText(work.getSubject().getTitle());
        holder.date.setText(work.getSubject().getYear());
        holder.role.setText(work.getDisplayRole());
        Glide.with(context).load(work.getSubject().getImages().getMedium()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return workList.size()>5?5:workList.size();
    }


    static class WorkHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView workName,role,date;
        private WorkHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_avatar);
            workName = itemView.findViewById(R.id.text_title);
            role = itemView.findViewById(R.id.text_role);
            date = itemView.findViewById(R.id.text_date);
        }
    }
}
