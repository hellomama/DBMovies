package com.tony.dbmovie.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.api.MoviesListApi;
import com.tony.dbmovie.commom.LoadMoreDelegate;
import com.tony.dbmovie.contract.MoviesContract;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.data.MovieResult;
import com.tony.dbmovie.network.NetworkHelper;
import com.tony.dbmovie.presenter.MoviesPresenter;
import com.tony.dbmovie.ui.binder.MoviesListBinder;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity implements MoviesContract.View,LoadMoreDelegate.LoadMoreSubject{

    private MultiTypeAdapter adapter;
    private MoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView listView = findViewById(R.id.list_movies);
        listView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MultiTypeAdapter();
        adapter.register(Movie.class,new MoviesListBinder());
        listView.setAdapter(adapter);

        presenter = new MoviesPresenter(this);
        presenter.getMovies(true);

        LoadMoreDelegate loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attachRecycleView(listView);

    }

    @Override
    public void onLoadMore() {
        presenter.getMovies(false);
    }

    @Override
    public boolean isLoading() {
        return false;
    }

    @Override
    public void updateMoviesList(List<Movie> movies) {
        adapter.setItems(movies);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadingMovies() {

    }

    @Override
    public void updateFail() {

    }
}
