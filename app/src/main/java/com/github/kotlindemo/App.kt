package com.github.kotlindemo

import android.app.Application
import com.github.kotlindemo.util.GlideUtil
import com.github.kotlindemo.util.ToastUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate();
        ToastUtil.initToastUtil(this);
        GlideUtil.initGlideUtil(this);
    }
}