package com.tony.dbmovie.presenter;

import com.tony.dbmovie.data.MovieDetail;


/**
 * Created by dev on 2/7/18.
 */

public interface OnMovieDetailListener {
    void onSuccess(MovieDetail detail);
    void onFail();
}
