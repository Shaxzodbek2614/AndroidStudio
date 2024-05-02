package com.example.rv2.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.rv2.R
import com.example.rv2.databinding.ItemRvBinding
import com.example.rv2.models.Predment

private const val TAG = "MovieAdapter"
class PredmentAdapter(var context: Context, var list:ArrayList<Predment>): RecyclerView.Adapter<PredmentAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(predment: Predment, position: Int){
            itemRvBinding.img.setImageResource(predment.image)
            itemRvBinding.name.text = predment.name
            itemRvBinding.color.setBackgroundColor(predment.color)
            val anim = AnimationUtils.loadAnimation(context, R.anim.anim1)
            itemRvBinding.root.startAnimation(anim)
            Log.d(TAG, "onBind: $position")
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