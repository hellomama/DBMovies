package com.tony.dbmovie.contract;

import com.tony.dbmovie.data.Celebrity;

/**
 * Created by bushi on 2018/3/25.
 */

public interface CelebrityContract {
    interface Model {
        void loadCelebrity(String id);
    }

    interface View {
        void showLoadingCelebrity();
        void updateCelebrity(Celebrity celebrity);
        void updateCelebrityFail();
    }

    interface Presenter {
        void getCelebrityInfo(String id);
    }
}
