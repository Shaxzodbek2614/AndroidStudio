package com.example.musicplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.adapter.MusicAdapter
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.utils.MYData

class MainActivity : AppCompatActivity() {
    lateinit var musicAdapter: MusicAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MYData.addMusic()

        musicAdapter = MusicAdapter( object :MusicAdapter.RvAction{
            override fun itemClic(position: Int) {
                val intent = Intent(this@MainActivity,SecundActivity::class.java)
                intent.putExtra("key",position)
                startActivity(intent)
            }
        },this,MYData.list)
        binding.rv.adapter = musicAdapter

        val itemTouchHelper = object :ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val dismissFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                return makeMovementFlags(dragFlag,dismissFlag)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                musicAdapter.onItemMoved(viewHolder.adapterPosition,target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                musicAdapter.onItemDismiss(viewHolder.adapterPosition)
            }
        }

        val itemTouch = ItemTouchHelper(itemTouchHelper)
        itemTouch.attachToRecyclerView(binding.rv)

    }

    override fun onDestroy() {
        super.onDestroy()
        MYData.list.clear()
    }
}