package com.tony.dbmovie.data;

import java.io.Serializable;

/**
 * Created by bushi on 2018/3/25.
 */

public abstract class BaseData implements Serializable {
    private int backgroundColor = 0xFFFFFF;

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
