package com.example.listadapter1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listadapter1.databinding.ItemRvBinding
import com.example.listadapter1.models.User
import com.squareup.picasso.Picasso

class UserAdapter(var rvAction: RvAction):ListAdapter<User,UserAdapter.Vh>(MyDiffUtil()) {

    class MyDiffUtil:DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }
    }

    inner class Vh(var itemRvBinding: ItemRvBinding): ViewHolder(itemRvBinding.root){
        fun onBind(user: User){
            itemRvBinding.txt.text = user.name
            Picasso.get().load(user.imageLink).into(itemRvBinding.imageRv)
            itemRvBinding.txt.setOnClickListener {
                rvAction.itemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
         return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
    interface RvAction{
        fun itemClick(user: User)
    }
}