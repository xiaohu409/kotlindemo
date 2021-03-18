package com.github.kotlindemo

import android.content.Context
import android.widget.Toast

class A {

    fun a(context : Context) {
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
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