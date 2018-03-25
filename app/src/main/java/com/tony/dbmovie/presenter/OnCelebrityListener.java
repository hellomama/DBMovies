package com.tony.dbmovie.presenter;

import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.MovieDetail;

/**
 * Created by bushi on 2018/3/25.
 */

public interface OnCelebrityListener {
    void onSuccess(Celebrity celebrity);
    void onFail();
}
