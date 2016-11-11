/*
 * Copyright (C) 2016 The AndroidSupportPLI Project
 */

package com.hyena.support.pli;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.v4.app.FragmentActivity;
import android.view.ActionMode;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by yangzc on 16/11/5.
 */
public class ActivityWrapper extends FragmentActivity {

    private Activity mWrappedActivity;

    public ActivityWrapper(Activity activity) {
        super();
        this.mWrappedActivity = activity;
    }

    @Override
    public Intent getIntent() {
        return mWrappedActivity.getIntent();
    }

    @Override
    public void setIntent(Intent newIntent) {
        mWrappedActivity.setIntent(newIntent);
    }

    @Override
    public WindowManager getWindowManager() {
        return mWrappedActivity.getWindowManager();
    }

    @Override
    public Window getWindow() {
        return mWrappedActivity.getWindow();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public LoaderManager getLoaderManager() {
        return mWrappedActivity.getLoaderManager();
    }

    @Override
    public View getCurrentFocus() {
        return mWrappedActivity.getCurrentFocus();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        mWrappedActivity.onCreate(savedInstanceState);
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        mWrappedActivity.onCreate(savedInstanceState, persistentState);
//    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        mWrappedActivity.onRestoreInstanceState(savedInstanceState);
//    }

//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
//        mWrappedActivity.onRestoreInstanceState(savedInstanceState, persistentState);
//    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        mWrappedActivity.onPostCreate(savedInstanceState);
//    }

//    @Override
//    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        mWrappedActivity.onPostCreate(savedInstanceState, persistentState);
//    }

//    @Override
//    protected void onStart() {
//        mWrappedActivity.onStart();
//    }

//    @Override
//    protected void onRestart() {
//        mWrappedActivity.onRestart();
//    }

//    @Override
//    public void onStateNotSaved() {
//        mWrappedActivity.onStateNotSaved();
//    }

//    @Override
//    protected void onResume() {
//        mWrappedActivity.onResume();
//    }

//    @Override
//    protected void onPostResume() {
//        mWrappedActivity.onPostResume();
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public boolean isVoiceInteraction() {
//        return mWrappedActivity.isVoiceInteraction();
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public boolean isVoiceInteractionRoot() {
//        return mWrappedActivity.isVoiceInteractionRoot();
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public VoiceInteractor getVoiceInteractor() {
//        return mWrappedActivity.getVoiceInteractor();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean isLocalVoiceInteractionSupported() {
//        return mWrappedActivity.isLocalVoiceInteractionSupported();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public void startLocalVoiceInteraction(Bundle privateOptions) {
//        mWrappedActivity.startLocalVoiceInteraction(privateOptions);
//    }

//    @Override
//    public void onLocalVoiceInteractionStarted() {
//        mWrappedActivity.onLocalVoiceInteractionStarted();
//    }

//    @Override
//    public void onLocalVoiceInteractionStopped() {
//        mWrappedActivity.onLocalVoiceInteractionStopped();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public void stopLocalVoiceInteraction() {
//        mWrappedActivity.stopLocalVoiceInteraction();
//    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        mWrappedActivity.onNewIntent(intent);
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        mWrappedActivity.onSaveInstanceState(outState);
//    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        mWrappedActivity.onSaveInstanceState(outState, outPersistentState);
//    }

//    @Override
//    protected void onPause() {
//        mWrappedActivity.onPause();
//    }

//    @Override
//    protected void onUserLeaveHint() {
//        mWrappedActivity.onUserLeaveHint();
//    }

//    @Override
//    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
//        return mWrappedActivity.onCreateThumbnail(outBitmap, canvas);
//    }

    @Override
    public CharSequence onCreateDescription() {
        return mWrappedActivity.onCreateDescription();
    }

//    @Override
//    public void onProvideAssistData(Bundle data) {
//        mWrappedActivity.onProvideAssistData(data);
//    }

//    @Override
//    public void onProvideAssistContent(AssistContent outContent) {
//        mWrappedActivity.onProvideAssistContent(outContent);
//    }

//    @Override
//    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
//        mWrappedActivity.onProvideKeyboardShortcuts(data, menu, deviceId);
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public boolean showAssist(Bundle args) {
//        return mWrappedActivity.showAssist(args);
//    }

//    @Override
//    protected void onStop() {
//        mWrappedActivity.onStop();
//    }

//    @Override
//    protected void onDestroy() {
//        mWrappedActivity.onDestroy();
//    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void reportFullyDrawn() {
        mWrappedActivity.reportFullyDrawn();
    }

//    @Override
//    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
//        mWrappedActivity.onMultiWindowModeChanged(isInMultiWindowMode);
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean isInMultiWindowMode() {
//        return mWrappedActivity.isInMultiWindowMode();
//    }

//    @Override
//    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
//        mWrappedActivity.onPictureInPictureModeChanged(isInPictureInPictureMode);
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean isInPictureInPictureMode() {
//        return mWrappedActivity.isInPictureInPictureMode();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public void enterPictureInPictureMode() {
//        mWrappedActivity.enterPictureInPictureMode();
//    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        mWrappedActivity.onConfigurationChanged(newConfig);
//    }

    @Override
    public int getChangingConfigurations() {
        return mWrappedActivity.getChangingConfigurations();
    }

    @Override
    public Object getLastNonConfigurationInstance() {
        return mWrappedActivity.getLastNonConfigurationInstance();
    }

//    @Override
//    public Object onRetainNonConfigurationInstance() {
//        return mWrappedActivity.onRetainNonConfigurationInstance();
//    }

//    @Override
//    public void onLowMemory() {
//        mWrappedActivity.onLowMemory();
//    }

//    @Override
//    public void onTrimMemory(int level) {
//        mWrappedActivity.onTrimMemory(level);
//    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public FragmentManager getFragmentManager() {
        return mWrappedActivity.getFragmentManager();
    }

//    @Override
//    public void onAttachFragment(Fragment fragment) {
//        mWrappedActivity.onAttachFragment(fragment);
//    }

    @Override
    public void startManagingCursor(Cursor c) {
        mWrappedActivity.startManagingCursor(c);
    }

    @Override
    public void stopManagingCursor(Cursor c) {
        mWrappedActivity.stopManagingCursor(c);
    }

    @Override
    public View findViewById(int id) {
        return mWrappedActivity.findViewById(id);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public ActionBar getActionBar() {
        return mWrappedActivity.getActionBar();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void setActionBar(Toolbar toolbar) {
//        mWrappedActivity.setActionBar(toolbar);
//    }

    @Override
    public void setContentView(int layoutResID) {
        mWrappedActivity.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        mWrappedActivity.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mWrappedActivity.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        mWrappedActivity.addContentView(view, params);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public TransitionManager getContentTransitionManager() {
//        return mWrappedActivity.getContentTransitionManager();
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void setContentTransitionManager(TransitionManager tm) {
//        mWrappedActivity.setContentTransitionManager(tm);
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public Scene getContentScene() {
//        return mWrappedActivity.getContentScene();
//    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        mWrappedActivity.setFinishOnTouchOutside(finish);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return mWrappedActivity.onKeyDown(keyCode, event);
//    }

//    @Override
//    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
//        return mWrappedActivity.onKeyLongPress(keyCode, event);
//    }

//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        return mWrappedActivity.onKeyUp(keyCode, event);
//    }

//    @Override
//    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
//        return mWrappedActivity.onKeyMultiple(keyCode, repeatCount, event);
//    }

//    @Override
//    public void onBackPressed() {
//        mWrappedActivity.onBackPressed();
//    }

//    @Override
//    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
//        return mWrappedActivity.onKeyShortcut(keyCode, event);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return mWrappedActivity.onTouchEvent(event);
//    }

//    @Override
//    public boolean onTrackballEvent(MotionEvent event) {
//        return mWrappedActivity.onTrackballEvent(event);
//    }

//    @Override
//    public boolean onGenericMotionEvent(MotionEvent event) {
//        return mWrappedActivity.onGenericMotionEvent(event);
//    }

//    @Override
//    public void onUserInteraction() {
//        mWrappedActivity.onUserInteraction();
//    }

//    @Override
//    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
//        mWrappedActivity.onWindowAttributesChanged(params);
//    }

//    @Override
//    public void onContentChanged() {
//        mWrappedActivity.onContentChanged();
//    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        mWrappedActivity.onWindowFocusChanged(hasFocus);
//    }

//    @Override
//    public void onAttachedToWindow() {
//        mWrappedActivity.onAttachedToWindow();
//    }

//    @Override
//    public void onDetachedFromWindow() {
//        mWrappedActivity.onDetachedFromWindow();
//    }

    @Override
    public boolean hasWindowFocus() {
        return mWrappedActivity.hasWindowFocus();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return mWrappedActivity.dispatchKeyEvent(event);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return mWrappedActivity.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mWrappedActivity.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        return mWrappedActivity.dispatchTrackballEvent(ev);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return mWrappedActivity.dispatchGenericMotionEvent(ev);
    }

    @TargetApi(Build.VERSION_CODES.DONUT)
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return mWrappedActivity.dispatchPopulateAccessibilityEvent(event);
    }

//    @Nullable
//    @Override
//    public View onCreatePanelView(int featureId) {
//        return mWrappedActivity.onCreatePanelView(featureId);
//    }

//    @Override
//    public boolean onCreatePanelMenu(int featureId, Menu menu) {
//        return mWrappedActivity.onCreatePanelMenu(featureId, menu);
//    }

//    @Override
//    public boolean onPreparePanel(int featureId, View view, Menu menu) {
//        return mWrappedActivity.onPreparePanel(featureId, view, menu);
//    }

//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        return mWrappedActivity.onMenuOpened(featureId, menu);
//    }

//    @Override
//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//        return mWrappedActivity.onMenuItemSelected(featureId, item);
//    }

//    @Override
//    public void onPanelClosed(int featureId, Menu menu) {
//        mWrappedActivity.onPanelClosed(featureId, menu);
//    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void invalidateOptionsMenu() {
        mWrappedActivity.invalidateOptionsMenu();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return mWrappedActivity.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        return mWrappedActivity.onPrepareOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return mWrappedActivity.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onNavigateUp() {
//        return mWrappedActivity.onNavigateUp();
//    }

//    @Override
//    public boolean onNavigateUpFromChild(Activity child) {
//        return mWrappedActivity.onNavigateUpFromChild(child);
//    }

//    @Override
//    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
//        mWrappedActivity.onCreateNavigateUpTaskStack(builder);
//    }

//    @Override
//    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
//        mWrappedActivity.onPrepareNavigateUpTaskStack(builder);
//    }

//    @Override
//    public void onOptionsMenuClosed(Menu menu) {
//        mWrappedActivity.onOptionsMenuClosed(menu);
//    }

//    @Override
//    public void openOptionsMenu() {
//        mWrappedActivity.openOptionsMenu();
//    }

    @Override
    public void closeOptionsMenu() {
        mWrappedActivity.closeOptionsMenu();
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        mWrappedActivity.onCreateContextMenu(menu, v, menuInfo);
//    }

    @Override
    public void registerForContextMenu(View view) {
        mWrappedActivity.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        mWrappedActivity.unregisterForContextMenu(view);
    }

    @Override
    public void openContextMenu(View view) {
        mWrappedActivity.openContextMenu(view);
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    public void closeContextMenu() {
        mWrappedActivity.closeContextMenu();
    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        return mWrappedActivity.onContextItemSelected(item);
//    }

//    @Override
//    public void onContextMenuClosed(Menu menu) {
//        mWrappedActivity.onContextMenuClosed(menu);
//    }

//    @Override
//    protected Dialog onCreateDialog(int id) {
//        return mWrappedActivity.onCreateDialog(id);
//    }

//    @Nullable
//    @Override
//    protected Dialog onCreateDialog(int id, Bundle args) {
//        return mWrappedActivity.onCreateDialog(id, args);
//    }

//    @Override
//    protected void onPrepareDialog(int id, Dialog dialog) {
//        mWrappedActivity.onPrepareDialog(id, dialog);
//    }

//    @Override
//    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
//        mWrappedActivity.onPrepareDialog(id, dialog, args);
//    }

//    @Override
//    public boolean onSearchRequested(SearchEvent searchEvent) {
//        return mWrappedActivity.onSearchRequested(searchEvent);
//    }

//    @Override
//    public boolean onSearchRequested() {
//        return mWrappedActivity.onSearchRequested();
//    }

    @Override
    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
        mWrappedActivity.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    @Override
    public void triggerSearch(String query, Bundle appSearchData) {
        mWrappedActivity.triggerSearch(query, appSearchData);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        mWrappedActivity.takeKeyEvents(get);
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return mWrappedActivity.getLayoutInflater();
    }

    @Override
    public MenuInflater getMenuInflater() {
        return mWrappedActivity.getMenuInflater();
    }

    @Override
    public void setTheme(int resid) {
        mWrappedActivity.setTheme(resid);
    }

//    @Override
//    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
//        mWrappedActivity.onApplyThemeResource(theme, resid, first);
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        mWrappedActivity.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public boolean shouldShowRequestPermissionRationale(String permission) {
//        return mWrappedActivity.shouldShowRequestPermissionRationale(permission);
//    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        mWrappedActivity.startActivityForResult(intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        mWrappedActivity.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void startActivity(Intent intent) {
        mWrappedActivity.startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivity(Intent intent, Bundle options) {
        mWrappedActivity.startActivity(intent, options);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void startActivities(Intent[] intents) {
        mWrappedActivity.startActivities(intents);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivities(Intent[] intents, Bundle options) {
        mWrappedActivity.startActivities(intents, options);
    }

    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        return mWrappedActivity.startActivityIfNeeded(intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode, Bundle options) {
        return mWrappedActivity.startActivityIfNeeded(intent, requestCode, options);
    }

    @Override
    public boolean startNextMatchingActivity(Intent intent) {
        return mWrappedActivity.startNextMatchingActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean startNextMatchingActivity(Intent intent, Bundle options) {
        return mWrappedActivity.startNextMatchingActivity(intent, options);
    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode) {
        mWrappedActivity.startActivityFromChild(child, intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode, Bundle options) {
        mWrappedActivity.startActivityFromChild(child, intent, requestCode, options);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        mWrappedActivity.startActivityFromFragment(fragment, intent, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, Bundle options) {
        mWrappedActivity.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        mWrappedActivity.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        mWrappedActivity.overridePendingTransition(enterAnim, exitAnim);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
//    @Nullable
//    @Override
//    public Uri getReferrer() {
//        return mWrappedActivity.getReferrer();
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public Uri onProvideReferrer() {
//        return mWrappedActivity.onProvideReferrer();
//    }

    @Override
    public String getCallingPackage() {
        return mWrappedActivity.getCallingPackage();
    }

    @Override
    public ComponentName getCallingActivity() {
        return mWrappedActivity.getCallingActivity();
    }

    @Override
    public void setVisible(boolean visible) {
        mWrappedActivity.setVisible(visible);
    }

    @Override
    public boolean isFinishing() {
        return mWrappedActivity.isFinishing();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public boolean isDestroyed() {
        return mWrappedActivity.isDestroyed();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean isChangingConfigurations() {
        return mWrappedActivity.isChangingConfigurations();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void recreate() {
        mWrappedActivity.recreate();
    }

    @Override
    public void finish() {
        mWrappedActivity.finish();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void finishAffinity() {
        mWrappedActivity.finishAffinity();
    }

    @Override
    public void finishFromChild(Activity child) {
        mWrappedActivity.finishFromChild(child);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void finishAfterTransition() {
//        mWrappedActivity.finishAfterTransition();
//    }

    @Override
    public void finishActivity(int requestCode) {
        mWrappedActivity.finishActivity(requestCode);
    }

    @Override
    public void finishActivityFromChild(Activity child, int requestCode) {
        mWrappedActivity.finishActivityFromChild(child, requestCode);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void finishAndRemoveTask() {
//        mWrappedActivity.finishAndRemoveTask();
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public boolean releaseInstance() {
//        return mWrappedActivity.releaseInstance();
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mWrappedActivity.onActivityResult(requestCode, resultCode, data);
//    }

//    @Override
//    public void onActivityReenter(int resultCode, Intent data) {
//        mWrappedActivity.onActivityReenter(resultCode, data);
//    }

    @Override
    public PendingIntent createPendingResult(int requestCode, Intent data, int flags) {
        return mWrappedActivity.createPendingResult(requestCode, data, flags);
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        mWrappedActivity.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public int getRequestedOrientation() {
        return mWrappedActivity.getRequestedOrientation();
    }

    @Override
    public int getTaskId() {
        return mWrappedActivity.getTaskId();
    }

    @Override
    public boolean isTaskRoot() {
        return mWrappedActivity.isTaskRoot();
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        return mWrappedActivity.moveTaskToBack(nonRoot);
    }

    @Override
    public String getLocalClassName() {
        return mWrappedActivity.getLocalClassName();
    }

    @Override
    public ComponentName getComponentName() {
        return mWrappedActivity.getComponentName();
    }

    @Override
    public SharedPreferences getPreferences(int mode) {
        return mWrappedActivity.getPreferences(mode);
    }

    @Override
    public Object getSystemService(String name) {
        return mWrappedActivity.getSystemService(name);
    }

    @Override
    public void setTitle(CharSequence title) {
        mWrappedActivity.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        mWrappedActivity.setTitle(titleId);
    }

    @Override
    public void setTitleColor(int textColor) {
        mWrappedActivity.setTitleColor(textColor);
    }

//    @Override
//    protected void onTitleChanged(CharSequence title, int color) {
//        mWrappedActivity.onTitleChanged(title, color);
//    }

//    @Override
//    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
//        mWrappedActivity.onChildTitleChanged(childActivity, title);
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
//        mWrappedActivity.setTaskDescription(taskDescription);
//    }

//    @Nullable
//    @Override
//    public View onCreateView(String name, Context context, AttributeSet attrs) {
//        return mWrappedActivity.onCreateView(name, context, attrs);
//    }

//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        return mWrappedActivity.onCreateView(parent, name, context, attrs);
//    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        mWrappedActivity.dump(prefix, fd, writer, args);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public boolean isImmersive() {
        return mWrappedActivity.isImmersive();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public boolean requestVisibleBehind(boolean visible) {
//        return mWrappedActivity.requestVisibleBehind(visible);
//    }

//    @Override
//    public void onVisibleBehindCanceled() {
//        mWrappedActivity.onVisibleBehindCanceled();
//    }

//    @Override
//    public void onEnterAnimationComplete() {
//        mWrappedActivity.onEnterAnimationComplete();
//    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void setImmersive(boolean i) {
        mWrappedActivity.setImmersive(i);
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public void setVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
//        mWrappedActivity.setVrModeEnabled(enabled, requestedComponent);
//    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return mWrappedActivity.startActionMode(callback);
    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Nullable
//    @Override
//    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
//        return mWrappedActivity.startActionMode(callback, type);
//    }

//    @Nullable
//    @Override
//    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
//        return mWrappedActivity.onWindowStartingActionMode(callback);
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Nullable
//    @Override
//    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
//        return mWrappedActivity.onWindowStartingActionMode(callback, type);
//    }

//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    @Override
//    public void onActionModeStarted(ActionMode mode) {
//        mWrappedActivity.onActionModeStarted(mode);
//    }

//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    @Override
//    public void onActionModeFinished(ActionMode mode) {
//        mWrappedActivity.onActionModeFinished(mode);
//    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        return mWrappedActivity.shouldUpRecreateTask(targetIntent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean navigateUpTo(Intent upIntent) {
        return mWrappedActivity.navigateUpTo(upIntent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return mWrappedActivity.navigateUpToFromChild(child, upIntent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Intent getParentActivityIntent() {
        return mWrappedActivity.getParentActivityIntent();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void setEnterSharedElementCallback(SharedElementCallback callback) {
//        mWrappedActivity.setEnterSharedElementCallback(callback);
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void setExitSharedElementCallback(SharedElementCallback callback) {
//        mWrappedActivity.setExitSharedElementCallback(callback);
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void postponeEnterTransition() {
//        mWrappedActivity.postponeEnterTransition();
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void startPostponedEnterTransition() {
//        mWrappedActivity.startPostponedEnterTransition();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
//        return mWrappedActivity.requestDragAndDropPermissions(event);
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void startLockTask() {
//        mWrappedActivity.startLockTask();
//    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void stopLockTask() {
//        mWrappedActivity.stopLockTask();
//    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public void showLockTaskEscapeMessage() {
//        mWrappedActivity.showLockTaskEscapeMessage();
//    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        mWrappedActivity.attachBaseContext(newBase);
//    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        mWrappedActivity.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public Resources.Theme getTheme() {
        return mWrappedActivity.getTheme();
    }

    @Override
    public Context getBaseContext() {
        return mWrappedActivity.getBaseContext();
    }

    @Override
    public PackageManager getPackageManager() {
        return mWrappedActivity.getPackageManager();
    }

    @Override
    public ContentResolver getContentResolver() {
        return mWrappedActivity.getContentResolver();
    }

    @Override
    public Looper getMainLooper() {
        return mWrappedActivity.getMainLooper();
    }

    @Override
    public Context getApplicationContext() {
        return mWrappedActivity.getApplicationContext();
    }

    @Override
    public String getPackageName() {
        return mWrappedActivity.getPackageName();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return mWrappedActivity.getApplicationInfo();
    }

    @Override
    public String getPackageResourcePath() {
        return mWrappedActivity.getPackageResourcePath();
    }

    @Override
    public String getPackageCodePath() {
        return mWrappedActivity.getPackageCodePath();
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return mWrappedActivity.getSharedPreferences(name, mode);
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
//        return mWrappedActivity.moveSharedPreferencesFrom(sourceContext, name);
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean deleteSharedPreferences(String name) {
//        return mWrappedActivity.deleteSharedPreferences(name);
//    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return mWrappedActivity.openFileInput(name);
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return mWrappedActivity.openFileOutput(name, mode);
    }

    @Override
    public boolean deleteFile(String name) {
        return mWrappedActivity.deleteFile(name);
    }

    @Override
    public File getFileStreamPath(String name) {
        return mWrappedActivity.getFileStreamPath(name);
    }

    @Override
    public String[] fileList() {
        return mWrappedActivity.fileList();
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public File getDataDir() {
//        return mWrappedActivity.getDataDir();
//    }

    @Override
    public File getFilesDir() {
        return mWrappedActivity.getFilesDir();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public File getNoBackupFilesDir() {
//        return mWrappedActivity.getNoBackupFilesDir();
//    }

    @Override
    public File getExternalFilesDir(String type) {
        return mWrappedActivity.getExternalFilesDir(type);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public File[] getExternalFilesDirs(String type) {
        return mWrappedActivity.getExternalFilesDirs(type);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public File getObbDir() {
        return mWrappedActivity.getObbDir();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public File[] getObbDirs() {
        return mWrappedActivity.getObbDirs();
    }

    @Override
    public File getCacheDir() {
        return mWrappedActivity.getCacheDir();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public File getCodeCacheDir() {
//        return mWrappedActivity.getCodeCacheDir();
//    }

    @Override
    public File getExternalCacheDir() {
        return mWrappedActivity.getExternalCacheDir();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public File[] getExternalCacheDirs() {
        return mWrappedActivity.getExternalCacheDirs();
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public File[] getExternalMediaDirs() {
//        return mWrappedActivity.getExternalMediaDirs();
//    }

    @Override
    public File getDir(String name, int mode) {
        return mWrappedActivity.getDir(name, mode);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return mWrappedActivity.openOrCreateDatabase(name, mode, factory);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return mWrappedActivity.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean moveDatabaseFrom(Context sourceContext, String name) {
//        return mWrappedActivity.moveDatabaseFrom(sourceContext, name);
//    }

    @Override
    public boolean deleteDatabase(String name) {
        return mWrappedActivity.deleteDatabase(name);
    }

    @Override
    public File getDatabasePath(String name) {
        return mWrappedActivity.getDatabasePath(name);
    }

    @Override
    public String[] databaseList() {
        return mWrappedActivity.databaseList();
    }

    @Override
    public Drawable getWallpaper() {
        return mWrappedActivity.getWallpaper();
    }

    @Override
    public Drawable peekWallpaper() {
        return mWrappedActivity.peekWallpaper();
    }

    @Override
    public int getWallpaperDesiredMinimumWidth() {
        return mWrappedActivity.getWallpaperDesiredMinimumWidth();
    }

    @Override
    public int getWallpaperDesiredMinimumHeight() {
        return mWrappedActivity.getWallpaperDesiredMinimumHeight();
    }

    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mWrappedActivity.setWallpaper(bitmap);
    }

    @Override
    public void setWallpaper(InputStream data) throws IOException {
        mWrappedActivity.setWallpaper(data);
    }

    @Override
    public void clearWallpaper() throws IOException {
        mWrappedActivity.clearWallpaper();
    }

    @Override
    public void sendBroadcast(Intent intent) {
        mWrappedActivity.sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mWrappedActivity.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        mWrappedActivity.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        mWrappedActivity.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user) {
        mWrappedActivity.sendBroadcastAsUser(intent, user);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        mWrappedActivity.sendBroadcastAsUser(intent, user, receiverPermission);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        mWrappedActivity.sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    @Override
    public void sendStickyBroadcast(Intent intent) {
        mWrappedActivity.sendStickyBroadcast(intent);
    }

    @Override
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        mWrappedActivity.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    @Override
    public void removeStickyBroadcast(Intent intent) {
        mWrappedActivity.removeStickyBroadcast(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
        mWrappedActivity.sendStickyBroadcastAsUser(intent, user);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        mWrappedActivity.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
        mWrappedActivity.removeStickyBroadcastAsUser(intent, user);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return mWrappedActivity.registerReceiver(receiver, filter);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return mWrappedActivity.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mWrappedActivity.unregisterReceiver(receiver);
    }

    @Override
    public ComponentName startService(Intent service) {
        return mWrappedActivity.startService(service);
    }

    @Override
    public boolean stopService(Intent name) {
        return mWrappedActivity.stopService(name);
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return mWrappedActivity.bindService(service, conn, flags);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        mWrappedActivity.unbindService(conn);
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return mWrappedActivity.startInstrumentation(className, profileFile, arguments);
    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public String getSystemServiceName(Class<?> serviceClass) {
//        return mWrappedActivity.getSystemServiceName(serviceClass);
//    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        return mWrappedActivity.checkPermission(permission, pid, uid);
    }

    @Override
    public int checkCallingPermission(String permission) {
        return mWrappedActivity.checkCallingPermission(permission);
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        return mWrappedActivity.checkCallingOrSelfPermission(permission);
    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public int checkSelfPermission(String permission) {
//        return mWrappedActivity.checkSelfPermission(permission);
//    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        mWrappedActivity.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        mWrappedActivity.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        mWrappedActivity.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mWrappedActivity.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mWrappedActivity.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return mWrappedActivity.checkUriPermission(uri, pid, uid, modeFlags);
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return mWrappedActivity.checkCallingUriPermission(uri, modeFlags);
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return mWrappedActivity.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return mWrappedActivity.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        mWrappedActivity.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        mWrappedActivity.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        mWrappedActivity.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        mWrappedActivity.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return mWrappedActivity.createPackageContext(packageName, flags);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        return mWrappedActivity.createConfigurationContext(overrideConfiguration);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public Context createDisplayContext(Display display) {
        return mWrappedActivity.createDisplayContext(display);
    }

    @Override
    public boolean isRestricted() {
        return mWrappedActivity.isRestricted();
    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public Context createDeviceProtectedStorageContext() {
//        return mWrappedActivity.createDeviceProtectedStorageContext();
//    }

//    @TargetApi(Build.VERSION_CODES.N)
//    @Override
//    public boolean isDeviceProtectedStorage() {
//        return mWrappedActivity.isDeviceProtectedStorage();
//    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        mWrappedActivity.registerComponentCallbacks(callback);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        mWrappedActivity.unregisterComponentCallbacks(callback);
    }

    @Override
    public Resources getResources() {
        //TODO 根据当前的模型类型,返回不同的resource
        return mWrappedActivity.getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mWrappedActivity.getClassLoader();
    }

    @Override
    public AssetManager getAssets() {
        return mWrappedActivity.getAssets();
    }

}
