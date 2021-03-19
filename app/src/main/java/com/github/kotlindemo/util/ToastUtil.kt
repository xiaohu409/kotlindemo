package com.github.kotlindemo.util

import android.content.Context
import android.widget.Toast

object ToastUtil {

    lateinit var context : Context;

    fun initToastUtil(context: Context) {
        this.context = context;
    }

    fun showShort(value : String) {
        if (context == null) {
            return;
        }
        Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
    }

}