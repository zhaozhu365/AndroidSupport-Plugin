/*
 * Copyright (C) 2016 The AndroidSupportPLI Project
 */

package com.hyena.support.pli;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;

import com.hyena.support.pli.helper.FileUtils;
import com.hyena.support.pli.helper.InvokeHelper;
import com.hyena.support.pli.helper.ZipUtils;

import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import dalvik.system.DexClassLoader;

/**
 * Created by yangzc on 16/11/10.
 */
public class ActivityHelper {

    public static ActivityWrapper buildActivityWrapper(Activity activity, final Module module) {
        final ModuleContext context = new ModuleContext(activity, module);
        ActivityWrapper wrapper = new ActivityWrapper(activity) {
            @Override
            public ClassLoader getClassLoader() {
                return context.getClassLoader();
            }

            @Override
            public Object getSystemService(String name) {
                return context.getSystemService(name);
            }
        };
        InvokeHelper.setFieldValue(ContextThemeWrapper.class, wrapper, "mBase", context);
        InvokeHelper.setFieldValue(ContextWrapper.class, wrapper, "mBase", context);
        return wrapper;
    }

    public static ClassLoader createClassLoader(String pluginId, String apkPath) {
        File optimizedFile = new File(getPluginDir(pluginId), "dex");
        final File soFile = new File(getPluginDir(pluginId), "so");
        if (!optimizedFile.exists()) {
            optimizedFile.mkdirs();
        }
        if (!soFile.exists()) {
            soFile.mkdirs();
        }

        //解压so
        ZipUtils.extract(apkPath, new ZipUtils.ZipEntryWalker() {
            @Override
            public void onEntry(ZipInputStream zis, ZipEntry entry) throws Exception {
                String entryName = entry.getName();
                if (TextUtils.isEmpty(entryName) || entryName.endsWith(".so"))
                    return;

                String fileName = entryName.substring(entryName.lastIndexOf("/") + 1);
                File targetFile = new File(soFile, fileName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                if (targetFile.exists()) {
                    targetFile.delete();
                }
                FileUtils.copyStream2File(zis, targetFile);
            }
        });

        ClassLoader parent = Thread.currentThread().getContextClassLoader();
//            parent = ClassLoader.getSystemClassLoader();
        return new DexClassLoader(apkPath, optimizedFile.getAbsolutePath(), soFile.getAbsolutePath(), parent);
    }

    public static Resources createResource(AssetManager assetManager, Resources resources) {
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    public static AssetManager createAssetManager(String apkPath) {
        AssetManager assetManager = (AssetManager) InvokeHelper.newInstanceObject(AssetManager.class);
        InvokeHelper.invokeMethod(assetManager, "addAssetPath", new Class[]{String.class}, new Object[]{apkPath});
        return assetManager;
    }

    /**
     * 获取插件缓存目录
     * @return
     */
    private static File getPluginDir(String pluginId) {
        File pluginRootDir = new File(getCacheDir(), "plugin");
        File pluginDir = new File(pluginRootDir, pluginId);
        if (!pluginDir.exists())
            pluginDir.mkdirs();
        return pluginDir;
    }

    private static File getCacheDir() {
        return BaseApp.getAppContext().getCacheDir();
    }
}
