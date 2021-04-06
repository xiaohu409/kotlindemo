package com.github.kotlindemo.base

/**
 * 权限授予接口
 */
interface BasePermission {
    //同意授予
    fun grant(requestCode : Int);
    //拒绝授予
    fun denied(requestCode: Int);
}