/*
 * Copyright (C) 2016 The AndroidSupport-Plugin Project
 */

package com.hyena.support.pli;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHostCallback;
import android.view.LayoutInflater;
import android.view.View;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by yangzc on 16/11/11.
 */
public class FragmentHostCallbackWrapper extends FragmentHostCallback {

    public FragmentHostCallbackWrapper(Context context, Handler handler, int windowAnimations) {
        super(context, handler, windowAnimations);
    }

    @Override
    public void onDump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.onDump(prefix, fd, writer, args);
    }

    @Override
    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return super.onShouldSaveFragmentState(fragment);
    }

    @Override
    public LayoutInflater onGetLayoutInflater() {
        return super.onGetLayoutInflater();
    }

    @Override
    public void onSupportInvalidateOptionsMenu() {
        super.onSupportInvalidateOptionsMenu();
    }

    @Override
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        super.onStartActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        super.onStartActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.onStartIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] permissions, int requestCode) {
        super.onRequestPermissionsFromFragment(fragment, permissions, requestCode);
    }

    @Override
    public boolean onShouldShowRequestPermissionRationale(@NonNull String permission) {
        return super.onShouldShowRequestPermissionRationale(permission);
    }

    @Override
    public boolean onHasWindowAnimations() {
        return super.onHasWindowAnimations();
    }

    @Override
    public int onGetWindowAnimations() {
        return super.onGetWindowAnimations();
    }

    @Nullable
    @Override
    public View onFindViewById(int id) {
        return super.onFindViewById(id);
    }

    @Override
    public boolean onHasView() {
        return super.onHasView();
    }

    @Nullable
    @Override
    public Object onGetHost() {
        return null;
    }
}
