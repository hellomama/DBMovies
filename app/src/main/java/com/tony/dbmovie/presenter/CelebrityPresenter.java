package com.tony.dbmovie.presenter;

import com.tony.dbmovie.contract.CelebrityContract;
import com.tony.dbmovie.data.Celebrity;
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
    public void onSuccess(Celebrity celebrity) {
        view.updateCelebrity(celebrity);
    }

    @Override
    public void onFail() {
        view.updateCelebrityFail();
    }
}
