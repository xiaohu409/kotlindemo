package com.github.kotlindemo.base

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * activity 基类
 */
abstract class BaseActivity : AppCompatActivity(), BaseUI, BaseData, View.OnClickListener, BasePermission {

    protected lateinit var activity : AppCompatActivity;
    //权限code
    protected var requestCameraXCode: Int = 0x01;

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

    /**
     * 权限
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        when (requestCode) {
            requestCameraXCode -> {
                if (hasPermission(grantResults)) {
                    grant(requestCameraXCode);
                }
                else {
                    denied(requestCameraXCode);
                }
            }
        }
    }

    /**
     * 遍历权限组结果
     */
    private fun hasPermission(grantResults: IntArray): Boolean {
        for (result: Int in grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 回调方法
     */
    override fun grant(requestCode: Int) {

    }

    /**
     * 回调方法
     */
    override fun denied(requestCode: Int) {

    }
}