package com.tony.dbmovie.contract;

import com.tony.dbmovie.data.Movie;

import java.util.List;

/**
 * Created by dev on 2/5/18.
 */

public interface MoviesContract {
    interface Model {
        void loadMovies(boolean clear);
    }

    interface View {
        void updateMoviesList(List<Movie> movies);
        void showLoadingMovies();
        void updateFail();
    }

    interface Presenter {
        void getMovies(boolean clear);
    }
}
