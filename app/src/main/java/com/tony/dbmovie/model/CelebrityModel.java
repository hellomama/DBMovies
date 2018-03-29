package com.tony.dbmovie.model;

import com.tony.dbmovie.api.CelebrityApi;
import com.tony.dbmovie.contract.CelebrityContract;
import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;
import com.tony.dbmovie.network.NetworkHelper;
import com.tony.dbmovie.presenter.OnCelebrityListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bushi on 2018/3/25.
 */

public class CelebrityModel implements CelebrityContract.Model {

    private CelebrityApi celebrityApi;
    private OnCelebrityListener listener;

    public CelebrityModel() {
        if (celebrityApi == null)
        {
            celebrityApi = NetworkHelper.getInstance().createApi(CelebrityApi.class);
        }
    }

    public void setListener(OnCelebrityListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadCelebrity(final String id) {
        celebrityApi.getCelebrity(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Celebrity>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Celebrity celebrity) {
                        if (listener != null)
                        {
                            listener.onCelebritySuccess(celebrity);
                        }
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
                        loadWork(id);
                    }
                });
    }

    @Override
    public void loadWork(final String id) {
        celebrityApi.getWorks(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WorkResult>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(WorkResult workResult) {
                        if (listener != null)
                        {
                            listener.onWorkSuccess(workResult);
                        }
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
                        loadPhoto(id);
                    }
                });
    }

    @Override
    public void loadPhoto(final String id) {
        celebrityApi.getPhotos(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhotoResult>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(PhotoResult photoResult) {
                        if (listener != null)
                        {
                            listener.onPhotoSuccess(photoResult);
                        }
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
