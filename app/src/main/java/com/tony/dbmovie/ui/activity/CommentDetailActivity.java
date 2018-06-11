package com.tony.dbmovie.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.tony.dbmovie.R;
import com.tony.dbmovie.api.CommentApi;
import com.tony.dbmovie.common.Common;
import com.tony.dbmovie.network.NetworkHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dev on 4/12/18.
 */

public class CommentDetailActivity extends BaseActivity {

    private String id;

    public static void start(Context context, String id) {
        Intent starter = new Intent(context, CommentDetailActivity.class);
        starter.putExtra(Common.EXTRA_DATA,id);
        context.startActivity(starter);
    }

    private void parse()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            id = intent.getStringExtra(Common.EXTRA_DATA);
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        parse();

        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolbarNav(toolbar);

//        RecyclerView recyclerView = findViewById(R.id.list);
        CommentApi api = NetworkHelper.getInstance().createApi(CommentApi.class);
        if (!TextUtils.isEmpty(id))
        {
            api.getMovieComment(id,0,20).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {

                        }
                    });
        }
    }
}
