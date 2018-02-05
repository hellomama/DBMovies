package com.tony.dbmovie.presenter;

import com.tony.dbmovie.contract.MoviesContract;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.model.MoviesModel;

import java.util.List;

/**
 * Created by dev on 2/5/18.
 */

public class MoviesPresenter implements MoviesContract.Presenter,OnMoviesListener {

    private MoviesContract.View mView;
    private MoviesModel mModel;

    public MoviesPresenter(MoviesContract.View view) {
        mView = view;
        mModel = new MoviesModel();
        mModel.setListener(this);
    }

    @Override
    public void getMovies(boolean clear) {
        mModel.loadMovies(clear);
        mView.showLoadingMovies();
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        mView.updateMoviesList(movies);
    }

    @Override
    public void onFail() {
        mView.updateFail();
    }
}
