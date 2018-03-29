package com.tony.dbmovie.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Work;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class AllWorksAdapter extends RecyclerView.Adapter {

    private final static String FORMAT = "共%1$s部电影作品";

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Work> workList = new ArrayList<>();

    private enum EDisplayType
    {
        ETitle(0),
        EWork(1);

        private int mType;
        EDisplayType(int aType)
        {
            mType = aType;
        }

        int type()
        {
            return mType;
        }

        public static EDisplayType type(int aType)
        {
            for (EDisplayType displayType : EDisplayType.values())
            {
                if (displayType.mType == aType)
                {
                    return displayType;
                }
            }

            return EWork;
        }
    }


    public AllWorksAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        if (viewType == EDisplayType.ETitle.type())
        {
            view = layoutInflater.inflate(R.layout.item_allwork_title,parent,false);
            return new TitleHolder(view);
        }else {
            view = layoutInflater.inflate(R.layout.item_work,parent,false);
            return new WorkAdapter.WorkHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder baseHolder, int position) {
        if (baseHolder instanceof TitleHolder)
        {
            TitleHolder titleHolder = (TitleHolder)baseHolder;
            titleHolder.title.setText(String.format(FORMAT,String.valueOf(workList.size())));
        }else if (baseHolder instanceof WorkAdapter.WorkHolder)
        {
            WorkAdapter.WorkHolder workHolder = (WorkAdapter.WorkHolder)baseHolder;
            Work work = workList.get(position -1);
            workHolder.workName.setText(work.getSubject().getTitle());
            workHolder.date.setText(work.getSubject().getYear());
            workHolder.role.setText(work.getDisplayRole());
            Glide.with(context).load(work.getSubject().getImages().getMedium()).into(workHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return workList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0?EDisplayType.ETitle.type():EDisplayType.EWork.type();
    }

    static class TitleHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        public TitleHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
        }
    }
}
