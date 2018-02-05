package com.tony.dbmovie.presenter;

import com.tony.dbmovie.data.Movie;

import java.util.List;

/**
 * Created by dev on 2/5/18.
 */

public interface OnMoviesListener {
    void onSuccess(List<Movie> movies);
    void onFail();
}
