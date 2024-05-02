package com.example.unverstetda

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unverstetda.databinding.ItemRvBinding

private const val TAG = "UserAdapter"
class UserAdapter(var context: Context, var list:ArrayList<String>): RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding ):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(string: String, position: Int){
            itemRvBinding.txt.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}