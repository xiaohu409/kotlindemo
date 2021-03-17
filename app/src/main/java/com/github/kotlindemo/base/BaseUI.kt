package com.github.kotlindemo.base

import android.view.View

/**
 * 视图实例化接口
 */
interface BaseUI {

    fun getLayoutId() : Int
    fun getView() : View
    fun initUI();

}