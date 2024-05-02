package com.example.salohiddin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.salohiddin.databinding.ItemRvBinding
import com.example.salohiddin.model.Model

private const val TAG = "ModelAdapter"
class ModelAdapter(var context: Context, var list:ArrayList<Model>): RecyclerView.Adapter<ModelAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(model: Model, position: Int){
           itemRvBinding.name.text = model.name
            itemRvBinding.age.text = model.age.toString()
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