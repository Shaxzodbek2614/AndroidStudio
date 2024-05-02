package com.example.mohirdevdiffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mohirdevdiffutil.databinding.ItemListAdapterBinding

private class DiffUtils:DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem===newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
       return oldItem==newItem
    }
}

class MyListAdapter():ListAdapter<String,MyListAdapter.Vh>(DiffUtils()) {
    inner class Vh(var itemListAdapterBinding: ItemListAdapterBinding):
        ViewHolder(itemListAdapterBinding.root){
            fun bind(title:String){
                itemListAdapterBinding.tvText.text = title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemListAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind(getItem(position))
    }
}