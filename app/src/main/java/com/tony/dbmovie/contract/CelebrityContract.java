package com.tony.dbmovie.contract;

import com.tony.dbmovie.data.Celebrity;
import com.tony.dbmovie.data.PhotoResult;
import com.tony.dbmovie.data.WorkResult;

/**
 * Created by bushi on 2018/3/25.
 */

public interface CelebrityContract {
    interface Model {
        void loadCelebrity(String id);
        void loadWork(String id);
        void loadPhoto(String id);
    }

    interface View {
        void showLoadingCelebrity();
        void updateCelebrity(Celebrity celebrity);
        void updateWork(WorkResult workResult);
        void updatePhoto(PhotoResult photoResult);
        void updateCelebrityFail();
    }

    interface Presenter {
        void getCelebrityInfo(String id);
        void getWorks(String id);
        void getPhoto(String id);
    }
}
