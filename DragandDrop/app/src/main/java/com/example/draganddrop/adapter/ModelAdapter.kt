package com.example.draganddrop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.draganddrop.R
import com.example.draganddrop.databinding.ItemRvBinding
import com.example.draganddrop.models.Model
import com.example.draganddrop.utils.MyData

private const val TAG = "ModelAdapter"
class ModelAdapter(var context: Context, var list:ArrayList<Model>): RecyclerView.Adapter<ModelAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(model: Model, position: Int){
            itemRvBinding.image.setImageResource(model.image)
            itemRvBinding.name.text = model.name
            if (MyData.count==0) {
                val anim = AnimationUtils.loadAnimation(context, R.anim.anim1)
                itemRvBinding.root.startAnimation(anim)
                if (!MyData.delete){
                    val anim_delete = AnimationUtils.loadAnimation(context, R.anim.anim_delete1)
                    itemRvBinding.root.startAnimation(anim_delete)
                    MyData.delete = true
                }
            }else if (MyData.count==1){
                val anim = AnimationUtils.loadAnimation(context, R.anim.anim2)
                itemRvBinding.root.startAnimation(anim)
                if (!MyData.delete){
                    val anim_delete = AnimationUtils.loadAnimation(context, R.anim.anim_delete2)
                    itemRvBinding.root.startAnimation(anim_delete)
                    MyData.delete = true
                }
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
}