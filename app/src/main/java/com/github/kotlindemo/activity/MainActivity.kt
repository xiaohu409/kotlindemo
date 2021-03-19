package com.github.kotlindemo.activity

import android.content.Intent
import android.view.View
import com.github.kotlindemo.A
import com.github.kotlindemo.R
import com.github.kotlindemo.base.BaseActivity
import com.github.kotlindemo.databinding.ActivityMainBinding

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
        binding.btnId.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_id -> {
                var intent = Intent(activity, RecyclerActivity::class.java);
                startActivity(intent);
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


}