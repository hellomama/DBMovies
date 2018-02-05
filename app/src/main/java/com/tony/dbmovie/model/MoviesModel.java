package com.tony.dbmovie.model;

import com.tony.dbmovie.api.MoviesListApi;
import com.tony.dbmovie.contract.MoviesContract;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.data.MovieResult;
import com.tony.dbmovie.network.NetworkHelper;
import com.tony.dbmovie.presenter.OnMoviesListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dev on 2/5/18.
 */

public class MoviesModel implements MoviesContract.Model {

    private OnMoviesListener listener;
    private MoviesListApi api;
    private int offset = 0;

    public MoviesModel() {
        api = NetworkHelper.getInstance().createApi(MoviesListApi.class);
    }

    public void setListener(OnMoviesListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadMovies(boolean clear) {

        if (clear)
        {
            offset = 0;
        }
        api.getMovieList("guangzhou",offset,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<MovieResult, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResult movieResult) throws Exception {
                        return movieResult.getSubjects();
                    }
                })
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        if (listener != null)
                        {
                            listener.onSuccess(movies);
                        }
                        offset += movies.size();
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (listener != null)
                        {
                            listener.onFail();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
