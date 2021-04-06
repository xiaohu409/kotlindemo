package com.github.kotlindemo

import android.app.Application
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig
import com.github.kotlindemo.util.GlideUtil
import com.github.kotlindemo.util.ToastUtil

/**
 * App
 */
open class App : Application(), CameraXConfig.Provider {

    override fun onCreate() {
        super.onCreate();
        ToastUtil.initToastUtil(this);
        GlideUtil.initGlideUtil(this);
    }

    override fun getCameraXConfig(): CameraXConfig {
        return Camera2Config.defaultConfig();
    }
}