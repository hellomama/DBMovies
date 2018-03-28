package com.tony.dbmovie.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.tony.dbmovie.R;
import com.tony.dbmovie.common.Common;
import com.tony.dbmovie.contract.CelebrityContract;
import com.tony.dbmovie.data.Cast;
import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.Director;
import com.tony.dbmovie.presenter.CelebrityPresenter;
import com.tony.dbmovie.ui.binder.CelebrityInfoBinder;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by bushi on 2018/3/24.
 */

public class CelebrityActivity extends BaseActivity implements CelebrityContract.View{

    private final static String TAG = CelebrityActivity.class.getName();
    private Cast cast;
    private Director director;
    private boolean isDirector = false;
    private MultiTypeAdapter adapter;
    private Items items;


    public static void start(Context context, Cast cast, ActivityOptions options) {
        Intent starter = new Intent(context, CelebrityActivity.class);
        starter.putExtra(Common.EXTRA_DATA,cast);
        if (options != null)
        {
            context.startActivity(starter,options.toBundle());
        }else {
            context.startActivity(starter);
        }
    }

    public static void start(Context context, Director director, ActivityOptions options) {
        Intent starter = new Intent(context, CelebrityActivity.class);
        starter.putExtra(Common.EXTRA_DATA,director);
        context.startActivity(starter,options.toBundle());
    }

    private void parseExtra()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            Object o = intent.getSerializableExtra(Common.EXTRA_DATA);
            if (o instanceof Cast)
            {
                cast = (Cast)o;
            }else if (o instanceof Director)
            {
                director = (Director)o;
                isDirector = true;
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity);
        parseExtra();

        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolbarNav(toolbar);
        toolbar.setTitle(cast.getName());
        RecyclerView recyclerView = findViewById(R.id.recycleView_celebrity);

        adapter = new MultiTypeAdapter();
        adapter.register(Celebrity.class, new CelebrityInfoBinder());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        CelebrityPresenter presenter = new CelebrityPresenter(this);
        presenter.getCelebrityInfo(isDirector?director.getId():cast.getId());

        items = new Items();

    }

    @Override
    public void showLoadingCelebrity() {

    }

    @Override
    public void updateCelebrity(Celebrity celebrity) {
        if (celebrity != null)
        {
            celebrity.setBackgroundColor(isDirector?director.getBackgroundColor():cast.getBackgroundColor());
            Log.d(TAG,celebrity.getBackgroundColor()+"");
            items.add(celebrity);
            if (adapter != null)
            {
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void updateCelebrityFail() {

    }
}
