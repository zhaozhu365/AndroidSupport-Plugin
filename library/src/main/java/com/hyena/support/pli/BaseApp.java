/*
 * Copyright (C) 2016 The AndroidSupportPLI Project
 */

package com.hyena.support.pli;

import android.app.Application;
import android.content.Context;

/**
 * Created by yangzc on 16/11/11.
 */
public class BaseApp extends Application {

    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
