package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicplayer.adapter.MusicAdapter
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.utils.MyData

class MainActivity : AppCompatActivity() {
    private lateinit var musicAdapter: MusicAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addMusic()

        musicAdapter = MusicAdapter(object :MusicAdapter.RvAction{
            override fun itemClick(position: Int) {
                val mediaPlayer = MediaPlayer.create(this@MainActivity,MyData.list[position].music)
                mediaPlayer.start()
                Toast.makeText(this@MainActivity, "boshlandi", Toast.LENGTH_SHORT).show()
                var count = position
                mediaPlayer.isPlaying

            }
        },this,MyData.list)

        binding.rv.adapter = musicAdapter

    }
}