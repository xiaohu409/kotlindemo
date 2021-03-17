package com.github.kotlindemo.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseUI, BaseData, View.OnClickListener {

    protected lateinit var activity : AppCompatActivity;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this;
//        setContentView(getLayoutId())
        setContentView(getView());
        initUI();
        bindData();
    }

    override fun onClick(v: View?) {

    }
}