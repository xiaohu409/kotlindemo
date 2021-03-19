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
        var str = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=android&step_word=&hs=0&pn=2&spn=0&di=83820&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=862704645%2C1557247143&os=1573761079%2C2876924040&simid=4120662465%2C556173609&adpicid=0&lpn=0&ln=1910&fr=&fmq=1616116723975_R&fm=result&ic=&s=undefined&hd=&latest=&copyright=&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fwww.51wendang.com%2Fpic%2F88982b5f992fb00975b5df04%2F1-350-png_6_0_0_135_604_393_394_892.979_1262.879-350-0-0-350.jpg%26refer%3Dhttp%3A%2F%2Fwww.51wendang.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1618708737%26t%3D6ec241bb95876d38aad5d2e3a422d428&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bc8ojg1wg2_z%26e3Bv54AzdH3F15vAzdH3Fbblbdkculldukaal0ckc1ua9&gsm=3&rpstart=0&rpnum=0&islist=&querylist=&force=undefined";
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