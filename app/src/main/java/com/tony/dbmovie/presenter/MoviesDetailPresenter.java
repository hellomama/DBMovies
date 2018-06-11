package com.tony.dbmovie.presenter;

import com.tony.dbmovie.contract.MoviesDetailContract;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.model.MoviesDetailModel;

/**
 * Created by dev on 2/6/18.
 */

public class MoviesDetailPresenter implements MoviesDetailContract.Presenter, OnMovieDetailListener{


    private MoviesDetailContract.View view;
    private MoviesDetailModel model;

    public MoviesDetailPresenter(MoviesDetailContract.View view) {
        this.view = view;
        model = new MoviesDetailModel();
        model.setListener(this);
    }

    @Override
    public void getMovieDetail(String movieId) {
        model.loadMovieDetail(movieId);
        view.loadingMoviesDetail();
    }

    @Override
    public void onSuccess(MovieDetail detail) {
        view.updateMovieDetail(detail);
    }

    @Override
    public void onFail(String msg) {
        view.loadMovieFail(msg);
    }
}
