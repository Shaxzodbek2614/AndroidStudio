package com.example.rv1.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.rv1.Models.Movie
import com.example.rv1.R
import com.example.rv1.databinding.ItemRvBinding
import com.example.rv1.utils.Mydata

private const val TAG = "MovieAdapter"
class MovieAdapter(var context: Context, var list:ArrayList<Movie>):RecyclerView.Adapter<MovieAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(movie: Movie, position: Int){
            itemRvBinding.image.setImageResource(movie.image)
            itemRvBinding.name.text = movie.name
            itemRvBinding.views.text = movie.views
            itemRvBinding.date.text = movie.date
            Log.d(TAG, "onBind: $position")
            if (Mydata.count==1){
            val animation = AnimationUtils.loadAnimation(context, R.anim.anim1)
            itemRvBinding.root.startAnimation(animation)
            }else if (Mydata.count==2){
                val anim2 = AnimationUtils.loadAnimation(context,R.anim.anim2)
                itemRvBinding.root.startAnimation(anim2)
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