package com.tony.dbmovie.presenter;

import com.tony.dbmovie.contract.CelebrityContract;
import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;
import com.tony.dbmovie.model.CelebrityModel;

/**
 * Created by bushi on 2018/3/25.
 */

public class CelebrityPresenter implements CelebrityContract.Presenter, OnCelebrityListener{

    private CelebrityModel model;
    private CelebrityContract.View view;

    public CelebrityPresenter(CelebrityContract.View view) {
        this.view = view;
        model = new CelebrityModel();
        model.setListener(this);
    }

    @Override
    public void getCelebrityInfo(String id) {
        model.loadCelebrity(id);
        view.showLoadingCelebrity();
    }

    @Override
    public void getWorks(String id) {
        model.loadCelebrity(id);
    }

    @Override
    public void onCelebritySuccess(Celebrity celebrity) {
        view.updateCelebrity(celebrity);
    }


    @Override
    public void onWorkSuccess(WorkResult workResult) {
        view.updateWork(workResult);
    }

    @Override
    public void onPhotoSuccess(PhotoResult photoResult) {
        view.updatePhoto(photoResult);
    }

    @Override
    public void getPhoto(String id) {
        model.loadPhoto(id);
    }

    @Override
    public void onFail() {
        view.updateCelebrityFail();
    }
}
