package com.github.kotlindemo

import android.content.Context
import android.widget.Toast
import com.github.kotlindemo.util.ToastUtil

class A {

    fun a() {
//        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
        ToastUtil.showShort("test");
    }

    fun b(context : Context) : String {
        if (context != null) {
            return "hutao"
        }
        else {
            return "";
        }
    }

    fun isOdd(x: Int) = x % 2 != 0
}