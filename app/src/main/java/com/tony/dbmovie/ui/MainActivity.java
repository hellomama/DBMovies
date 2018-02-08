package com.tony.dbmovie.ui;

import android.app.ActivityOptions;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.View;
import android.view.Window;

import com.tony.dbmovie.R;
import com.tony.dbmovie.commom.LoadMoreDelegate;
import com.tony.dbmovie.contract.MoviesContract;
import com.tony.dbmovie.data.LoadMore;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.presenter.MoviesPresenter;
import com.tony.dbmovie.ui.binder.LoadMoreBinder;
import com.tony.dbmovie.ui.binder.MoviesListBinder;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity implements MoviesContract.View,LoadMoreDelegate.LoadMoreSubject{

    private MultiTypeAdapter adapter;
    private MoviesPresenter presenter;
    private boolean loadingMore = false;
    private Items mMoviesItems = new Items();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView listView = findViewById(R.id.list_movies);
        listView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MultiTypeAdapter();
        adapter.register(Movie.class,new MoviesListBinder(MainActivity.this));
        adapter.register(LoadMore.class,new LoadMoreBinder());
        listView.setAdapter(adapter);

        presenter = new MoviesPresenter(this);
        presenter.getMovies(true);

        LoadMoreDelegate loadMoreDelegate = new LoadMoreDelegate(this,mMoviesItems,adapter);
        loadMoreDelegate.attachRecycleView(listView);

    }

    @Override
    public void onLoadMore() {
        presenter.getMovies(false);
        loadingMore = true;
    }

    @Override
    public boolean isLoading() {
        return loadingMore || mMoviesItems.size() % 20 != 0;
    }

    @Override
    public void updateMoviesList(List<Movie> movies) {
        if (movies.size()>0) {
            if (loadingMore)
            {
                int originSize = mMoviesItems.size() - 1;
                mMoviesItems.remove(originSize);
                mMoviesItems.addAll(movies);
                adapter.notifyItemRangeInserted(originSize, movies.size() - 1);
            }else {
                mMoviesItems.addAll(movies);
                adapter.setItems(mMoviesItems);
                adapter.notifyDataSetChanged();
            }
        }
        loadingMore = false;
    }

    @Override
    public void showLoadingMovies() {

    }

    @Override
    public void updateFail() {
        loadingMore = false;
    }
}
