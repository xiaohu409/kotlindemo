package com.github.kotlindemo.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * activity 基类
 */
abstract class BaseActivity : AppCompatActivity(), BaseUI, BaseData, View.OnClickListener, BasePermission {

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    override fun grant(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun denied(requestCode: Int) {
        TODO("Not yet implemented")
    }
}