package com.tony.dbmovie.utils;

import android.util.DisplayMetrics;

import com.tony.dbmovie.App;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dev on 3/29/18.
 */

public class Utils {

    private static boolean sInit = false;
    private static int SCREEN_WIDTH = 0;
    private static int SCREEN_HEIGHT = 0;

    private static float SCREEN_DENSITY = 0;

    private static void init()
    {
        if (!sInit)
        {
            sInit = true;

            DisplayMetrics dm = App.getContext().getResources().getDisplayMetrics();

            SCREEN_WIDTH = dm.widthPixels;
            SCREEN_HEIGHT = dm.heightPixels;
            SCREEN_DENSITY = dm.density;
        }
    }

    public static int screenWidth()
    {
        init();
        return SCREEN_WIDTH;
    }

    public static int screenHeight()
    {
        init();
        return SCREEN_HEIGHT;
    }

    public static int dpToPixel(int aDp)
    {
        init();
        return (int) (aDp * SCREEN_DENSITY + 0.5);
    }

    public static int dimenToPixel(int aResourceId)
    {
        return (int) App.getContext().getResources().getDimension(aResourceId);
    }
}
