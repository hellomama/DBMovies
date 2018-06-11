package com.tony.dbmovie.model;

import com.tony.dbmovie.api.MovieDescriptionApi;
import com.tony.dbmovie.contract.MoviesDetailContract;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.network.CallBackWrapper;
import com.tony.dbmovie.network.NetworkHelper;
import com.tony.dbmovie.presenter.OnMovieDetailListener;
import com.tony.dbmovie.presenter.OnMoviesListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dev on 2/6/18.
 */

public class MoviesDetailModel implements MoviesDetailContract.Model {
    private MovieDescriptionApi api;
    private OnMovieDetailListener listener;

    public MoviesDetailModel() {
        if (api == null)
        {
            api = NetworkHelper.getInstance().createApi(MovieDescriptionApi.class);
        }
    }

    public void setListener(OnMovieDetailListener listener) {
        this.listener = listener;
    }


    @Override
    public void loadMovieDetail(String movieId) {

        api.getMovie(movieId,"guangzhou")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallBackWrapper<MovieDetail>()
                {
                    @Override
                    public void onBegin(Disposable d) {
                        super.onBegin(d);
                    }

                    @Override
                    public void onCancel(boolean isCancel) {
                        super.onCancel(isCancel);
                    }

                    @Override
                    public void onSuccess(MovieDetail movieDetail) {
                        if (listener != null)
                        {
                            listener.onSuccess(movieDetail);
                        }
                    }

                    @Override
                    public void onError(String msg, int code) {
                        if (listener != null)
                        {
                            listener.onFail(msg);
                        }
                    }
                });
//                .subscribe(new Subscriber<MovieDetail>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        s.request(Long.MAX_VALUE);
//                    }
//
//                    @Override
//                    public void onNext(MovieDetail movieDetail) {
//                        if (listener != null)
//                        {
//                            listener.onSuccess(movieDetail);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        if (listener != null)
//                        {
//                            listener.onFail();
//                        }
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
