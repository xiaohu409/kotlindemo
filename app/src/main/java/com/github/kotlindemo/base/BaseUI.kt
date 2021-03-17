package com.github.kotlindemo.base

import android.view.View

interface BaseUI {

    fun getLayoutId() : Int
    fun getView() : View
    fun initUI();

}