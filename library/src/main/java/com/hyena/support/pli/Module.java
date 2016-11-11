/*
 * Copyright (C) 2016 The AndroidSupport Project
 */

package com.hyena.support.pli;

import android.util.Log;

import com.hyena.support.pli.helper.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by yangzc on 16/11/7.
 */
public class Module {

    public String mModuleId = "apptext";
//    public int mVersionCode;
//    public String mVersionName;
//    public String mRemotePath;

    public String mClassName = "com.hyena.plugin.app.PluginFragment";

    private File mTargetFile;
    public Module() {
        File sdCardFile = new File(android.os.Environment.getExternalStorageDirectory(), "app-release-unsigned.apk");
        mTargetFile = new File(BaseApp.getAppContext().getCacheDir(), "app-debug.apk");
        try {
            if (mTargetFile.exists())
                mTargetFile.delete();

            FileUtils.copyFile(sdCardFile, mTargetFile);
            Log.v("yangzc", "exist: " + mTargetFile.exists() + ", path: " + mTargetFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocalPath() {
        return mTargetFile.getAbsolutePath();
    }

}
