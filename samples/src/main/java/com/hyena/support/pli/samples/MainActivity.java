/*
 * Copyright (C) 2016 The AndroidSupportPLI Project
 */

package com.hyena.support.pli.samples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentHostCallback;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hyena.support.pli.ActivityHelper;
import com.hyena.support.pli.ActivityWrapper;
import com.hyena.support.pli.Module;
import com.hyena.support.pli.helper.InvokeHelper;

/**
 * Created by yangzc on 16/11/10.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment();
    }

    private ActivityWrapper activity = null;

    private void showFragment() {
        Module module = new Module();
        activity = ActivityHelper.buildActivityWrapper(this, module);
        Fragment fragment = Fragment.instantiate(activity, module.mClassName, null);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment != null) {
            FragmentHostCallback callback = (FragmentHostCallback) InvokeHelper.getFieldValue(fragment, "mHost");
            InvokeHelper.setFieldValue(callback, "mContext", activity);
            InvokeHelper.setFieldValue(callback, "mActivity", activity);
        }
    }

}
