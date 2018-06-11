package com.tony.dbmovie.ui.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.tony.dbmovie.R;
import com.tony.dbmovie.common.Common;
import com.tony.dbmovie.data.WorkResult;
import com.tony.dbmovie.ui.adapter.AllWorksAdapter;

/**
 * Created by dev on 3/29/18.
 */

public class WorksActivity extends BaseActivity {

    private final static String FORMAT = "%1$s电影作品";
    private WorkResult workResult;

    public static void start(Context context, WorkResult workResult, ActivityOptions options) {
        Intent starter = new Intent(context, WorksActivity.class);
        starter.putExtra(Common.EXTRA_DATA,workResult);
        if (options != null)
        {
            context.startActivity(starter,options.toBundle());
        }else {
            context.startActivity(starter);
        }
    }

    private void parseExtra()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            workResult = (WorkResult) intent.getSerializableExtra(Common.EXTRA_DATA);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        parseExtra();

        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolbarNav(toolbar);
        toolbar.setTitle(String.format(FORMAT,workResult.getCelebrity().getName()));

        RecyclerView recyclerView = findViewById(R.id.list);
        AllWorksAdapter adapter = new AllWorksAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setWorkList(workResult.getWorks());
    }
}
