package com.tony.dbmovie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tony.dbmovie.R;
import com.tony.dbmovie.api.MoviesListApi;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.data.MovieResult;
import com.tony.dbmovie.network.NetworkHelper;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoviesListApi api = NetworkHelper.getInstance().createApi(MoviesListApi.class);
        api.getMovieList("guangzhou",0,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieResult>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(MovieResult movieResult) {
                        Log.d("TAG","count - "+movieResult.getCount());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
