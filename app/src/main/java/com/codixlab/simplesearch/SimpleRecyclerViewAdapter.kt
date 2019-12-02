package com.codixlab.simplesearch

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codixlab.simplesearch.databinding.ItemListBinding
import com.squareup.picasso.Picasso

class SimpleRecyclerViewAdapter(var context: Context, var DataList: ArrayList<Data>) : RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_list, null)
        val bi = DataBindingUtil.bind<ItemListBinding>(view)
        return ViewHolder(bi!!)

    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {

        holder.bi.name.text = DataList[i].name

        Picasso.get().load(DataList[i].image).into(holder.bi.image)


    }

    override fun getItemCount(): Int {
        return DataList.size
    }

    inner class ViewHolder(var bi: ItemListBinding) : RecyclerView.ViewHolder(bi.root)
}
