package com.example.musicplayer.adapter

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.databinding.ItemRvBinding
import com.example.musicplayer.models.Music
import com.example.musicplayer.utils.MyData

private const val TAG = "MovieAdapter"
class MusicAdapter(var rvAction: RvAction, var context: Context, var list:ArrayList<Music>): RecyclerView.Adapter<MusicAdapter.Vh>() {
    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(music: Music, position: Int) {
            itemRvBinding.name.text = music.name
            itemRvBinding.musicName.text = music.musicName

            itemRvBinding.root.setOnClickListener {
                rvAction.itemClick(position)
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
    interface RvAction {
        fun itemClick(position: Int)
    }

}