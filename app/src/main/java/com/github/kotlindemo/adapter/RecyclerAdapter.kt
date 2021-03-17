package com.github.kotlindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.kotlindemo.bean.ListBean
import com.github.kotlindemo.databinding.RecyclerItemBinding

class RecyclerAdapter(var list : MutableList<ListBean>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var bean : ListBean = list[position];
        holder.binding.itemTvId.text = bean.name;
        holder.binding.itemTvId.setOnClickListener(ItemClick(bean))
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