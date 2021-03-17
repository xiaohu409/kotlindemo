package com.github.kotlindemo

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kotlindemo.adapter.RecyclerAdapter
import com.github.kotlindemo.base.BaseActivity
import com.github.kotlindemo.bean.ListBean
import com.github.kotlindemo.databinding.ActivityRecyclerBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


open class RecyclerActivity : BaseActivity() {

    private lateinit var list : MutableList<ListBean>;
    private lateinit var binding : ActivityRecyclerBinding;
    private lateinit var recyclerAdapter: RecyclerAdapter;

    override fun getLayoutId(): Int {
        return R.layout.activity_recycler;
    }

    override fun getView(): View {
        binding = ActivityRecyclerBinding.inflate(layoutInflater);
        return binding.root;
    }

    override fun initUI() {
        binding.rvId.layoutManager = LinearLayoutManager(activity);
        list = ArrayList<ListBean>();
        recyclerAdapter = RecyclerAdapter(list);
        binding.rvId.adapter = recyclerAdapter;
    }

    override fun bindData() {
        var json = "[\n" +
                "    {\n" +
                "        \"name\": \"hutao\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"hutao\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"hutao\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"hutao\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"hutao\"\n" +
                "    }\n" +
                "]"
        var data : List<ListBean> = Gson().fromJson(json, object : TypeToken<List<ListBean>>() {}.type)
        list.addAll(data);
        recyclerAdapter.notifyDataSetChanged();
    }
}