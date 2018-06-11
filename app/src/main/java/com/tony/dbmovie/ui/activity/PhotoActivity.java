package com.tony.dbmovie.ui.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.tony.dbmovie.R;
import com.tony.dbmovie.common.Common;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.ui.adapter.PhotoAdapter;

/**
 * Created by dev on 3/29/18.
 */

public class PhotoActivity extends BaseActivity {
    private final static String FORMAT = "%1$s张相片";
    private PhotoResult photoResult;

    public static void start(Context context, PhotoResult photoResult, ActivityOptions options) {
        Intent starter = new Intent(context, PhotoActivity.class);
        starter.putExtra(Common.EXTRA_DATA,photoResult);
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
            photoResult = (PhotoResult) intent.getSerializableExtra(Common.EXTRA_DATA);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        parseExtra();

        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolbarNav(toolbar);
        toolbar.setTitle(String.format(FORMAT,photoResult.getCount()));

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        PhotoAdapter adapter = new PhotoAdapter(this,true);
        recyclerView.setAdapter(adapter);
        adapter.setPhotos(photoResult.getPhotos());
    }
}
