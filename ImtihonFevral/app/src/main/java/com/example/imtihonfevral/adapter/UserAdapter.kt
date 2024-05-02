package com.example.imtihonfevral.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imtihonfevral.databinding.ItemRvBinding
import com.example.imtihonfevral.model.User

private const val TAG = "UserAdapter"
class UserAdapter(var context: Context, var list:ArrayList<User>): RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User, position: Int){
            itemRvBinding.name.text = user.name
            itemRvBinding.address.text = user.address
            itemRvBinding.seriya.text = user.seria
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