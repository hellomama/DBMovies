package com.tony.dbmovie.contract;

import com.tony.dbmovie.data.MovieDetail;

/**
 * Created by dev on 2/6/18.
 */

public interface MoviesDetailContract {

    interface Model {
        void loadMovieDetail(String movieId);
    }

    interface View {
        void loadingMoviesDetail();
        void updateMovieDetail(MovieDetail detail);
        void loadMovieFail(String msg);
    }

    interface Presenter {
        void getMovieDetail(String movieId);
    }
}
