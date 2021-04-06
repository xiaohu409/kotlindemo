package com.github.kotlindemo.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.kotlindemo.R

object GlideUtil {

    private lateinit var context: Context;

    fun initGlideUtil(context: Context) {
        this.context = context;
    }

    fun loadImage(imgUrl: String, imageView : ImageView) {
        val options: RequestOptions = RequestOptions()
            .placeholder(R.drawable.ic_image_black_72dp)
            .error(R.drawable.ic_image_black_72dp)
        Glide.with(context).load(imgUrl).apply(options)
            .into(imageView)
    }

}