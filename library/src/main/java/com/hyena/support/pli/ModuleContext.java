/*
 * Copyright (C) 2016 The AndroidSupport Project
 */

package com.hyena.support.pli;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

/**
 * Created by yangzc on 16/6/29.
 */
public class ModuleContext extends ContextThemeWrapper {

    private static final String TAG = "ModuleContext";

    private String mPluginId;
    private String mPluginPath;

    private Resources mResources;
    private Resources mRawResource;
    private AssetManager mAssetManager;
    private LayoutInflater mLayoutInflater;
    private ClassLoader mClassLoader;

    public ModuleContext(Context base, Module module) {
        super(base, 0);
        this.mPluginId = module.mModuleId;
        this.mPluginPath = module.getLocalPath();
        initClassLoader();
        this.mRawResource = base.getResources();
    }

    private void initClassLoader() {
        if (mClassLoader == null) {
            mClassLoader = ActivityHelper.createClassLoader(mPluginId, mPluginPath);
        }
    }

    @Override
    public Resources getResources() {
        if (mResources == null) {
            mResources = ActivityHelper.createResource(getAssets(), mRawResource);
        }
        return mResources;
    }

    @Override
    public AssetManager getAssets() {
        if (mAssetManager == null) {
            mAssetManager = ActivityHelper.createAssetManager(mPluginPath);
        }
        return mAssetManager;
    }

    @Override
    public Object getSystemService(String name) {
        if (Context.LAYOUT_INFLATER_SERVICE.equals(name)) {
            if (mLayoutInflater == null)
                mLayoutInflater = new ModuleLayoutInflater(this);
            return mLayoutInflater;
        }
        return super.getSystemService(name);
    }

    @Override
    public ClassLoader getClassLoader() {
        return mClassLoader;
    }

}
