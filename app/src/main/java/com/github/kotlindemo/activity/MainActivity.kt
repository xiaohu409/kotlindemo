package com.github.kotlindemo.activity

import android.Manifest
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.core.app.ActivityCompat
import com.github.kotlindemo.A
import com.github.kotlindemo.R
import com.github.kotlindemo.base.BaseActivity
import com.github.kotlindemo.databinding.ActivityMainBinding
import com.github.kotlindemo.util.ToastUtil


/**
 * 主界面
 */
class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding;

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }

    override fun getView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater);
        return binding.root;
    }

    override fun initUI() {
        binding.tvId.text = "胡桃";
        binding.tvId.setTextColor(resources.getColor(R.color.colorAccent))
        binding.rvBtnId.setOnClickListener(this);
        binding.cameraBtnId.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rv_btn_id -> {
                var intent = Intent(activity, RecyclerActivity::class.java);
                startActivity(intent);
            }

            R.id.camera_btn_id -> {
//                var intent = Intent(activity, CameraXActivity::class.java);
//                startActivity(intent);
                requestPermission()
            }

        }
    }

    override fun bindData() {
        var t = A();
        t.a();
        println();
        val numbers = listOf(1, 2, 3)
        println(numbers.filter(t::isOdd))
    }

    /**
     * 请求权限
     */
    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE), requestCameraXCode);
        }
        else {
            var intent = Intent(activity, CameraXActivity::class.java);
            startActivity(intent);
        }
    }

    override fun grant(requestCode: Int) {
        ToastUtil.showShort("授予权限");
        var intent = Intent(activity, CameraXActivity::class.java);
        startActivity(intent);
    }

    override fun denied(requestCode: Int) {
        ToastUtil.showShort("拒绝权限");
    }
}