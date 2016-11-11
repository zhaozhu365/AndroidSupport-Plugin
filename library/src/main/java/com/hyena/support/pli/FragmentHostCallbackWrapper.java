/*
 * Copyright (C) 2016 The AndroidSupport-Plugin Project
 */

package com.hyena.support.pli;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentHostCallback;
import android.view.LayoutInflater;
import android.view.View;

import com.hyena.support.pli.helper.InvokeHelper;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by yangzc on 16/11/11.
 */
public class FragmentHostCallbackWrapper extends FragmentHostCallback {

    private FragmentHostCallback mWrapper;

    public FragmentHostCallbackWrapper(FragmentHostCallback wrapper, FragmentActivity activity) {
        super(activity, null, 0);
        this.mWrapper = wrapper;
        Handler handler = (Handler) InvokeHelper.getFieldValue(activity, "mHandler");
        InvokeHelper.setFieldValue(this, "mActivity", activity);
        InvokeHelper.setFieldValue(this, "mHandler", handler);
    }

    @Override
    public void onDump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        mWrapper.onDump(prefix, fd, writer, args);
    }

    @Override
    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return mWrapper.onShouldSaveFragmentState(fragment);
    }

    @Override
    public LayoutInflater onGetLayoutInflater() {
        return mWrapper.onGetLayoutInflater();
    }

    @Override
    public void onSupportInvalidateOptionsMenu() {
        mWrapper.onSupportInvalidateOptionsMenu();
    }

    @Override
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        mWrapper.onStartActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        mWrapper.onStartActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        mWrapper.onStartIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] permissions, int requestCode) {
        mWrapper.onRequestPermissionsFromFragment(fragment, permissions, requestCode);
    }

    @Override
    public boolean onShouldShowRequestPermissionRationale(@NonNull String permission) {
        return mWrapper.onShouldShowRequestPermissionRationale(permission);
    }

    @Override
    public boolean onHasWindowAnimations() {
        return mWrapper.onHasWindowAnimations();
    }

    @Override
    public int onGetWindowAnimations() {
        return mWrapper.onGetWindowAnimations();
    }

    @Nullable
    @Override
    public View onFindViewById(int id) {
        return mWrapper.onFindViewById(id);
    }

    @Override
    public boolean onHasView() {
        return mWrapper.onHasView();
    }

    @Nullable
    @Override
    public Object onGetHost() {
        return mWrapper.onGetHost();
    }
}
