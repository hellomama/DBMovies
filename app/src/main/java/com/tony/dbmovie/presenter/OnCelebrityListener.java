package com.tony.dbmovie.presenter;

import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.MovieDetail;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;

/**
 * Created by bushi on 2018/3/25.
 */

public interface OnCelebrityListener {
    void onCelebritySuccess(Celebrity celebrity);
    void onWorkSuccess(WorkResult workResult);
    void onPhotoSuccess(PhotoResult photoResult);
    void onFail();
}
