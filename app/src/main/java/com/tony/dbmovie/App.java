package com.tony.dbmovie;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by dev on 3/29/18.
 */

public class App extends Application {
    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    synchronized public static App getApplication() {
        return sApp;
    }

    synchronized public static Context getAppContext() {
        if(sApp != null)
            return sApp.getApplicationContext();
        return null;
    }

    public static Context getContext()
    {
        return sApp.getApplicationContext();
    }
}
