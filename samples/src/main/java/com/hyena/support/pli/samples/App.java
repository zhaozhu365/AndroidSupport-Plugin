/*
 * Copyright (C) 2016 The AndroidSupportPLI Project
 */

package com.hyena.support.pli.samples;

import android.content.Context;

import com.hyena.framework.utils.BaseApp;

/**
 * Created by yangzc on 16/11/10.
 */
public class App extends BaseApp {

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
