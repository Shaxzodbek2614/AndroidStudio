package com.example.smssherlar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smssherlar.R
import com.example.smssherlar.databinding.ItemRvBinding
import com.example.smssherlar.models.Sher

private const val TAG = "MovieAdapter"
class SherlarAdapter(var rvAction: RvAction,var context: Context?, var list:ArrayList<Sher>): RecyclerView.Adapter<SherlarAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(sher: Sher, position: Int){
            itemRvBinding.name.text = sher.name
            itemRvBinding.deck.text = sher.deck
            itemRvBinding.love.setOnClickListener {
                if (!sher.like){
                    itemRvBinding.love.setImageResource(R.drawable.love)
                    sher.like=true
                }else{
                    itemRvBinding.love.setImageResource(R.drawable.frame)
                    sher.like=false
                }
            }
            itemRvBinding.root.setOnLongClickListener {
                rvAction.onClick(position)
                true
            }

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
    interface RvAction{
        fun onClick(position: Int)
    }
}