package com.github.kotlindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.kotlindemo.bean.ListBean
import com.github.kotlindemo.databinding.RecyclerItemBinding
import com.github.kotlindemo.util.GlideUtil

/**
 * 适配器
 */
class RecyclerAdapter(var list : MutableList<ListBean>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var bean : ListBean = list[position];
        holder.binding.tvId.text = bean.name;
        holder.binding.tvId.setOnClickListener(ItemClick(bean));
        var str = "https://img1.baidu.com/it/u=1416473742,1644155851&fm=26&fmt=auto&gp=0.jpg";
        GlideUtil.loadImage(str, holder.binding.imgId);
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    class Holder(var binding : RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    /**
     * view item 点击事件
     */
    class ItemClick(var bean: ListBean) : View.OnClickListener {
        override fun onClick(v: View?) {
            Toast.makeText(v?.context, bean.name, Toast.LENGTH_SHORT).show();
        }
    }
}