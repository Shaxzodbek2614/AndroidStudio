package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.example.musicplayer.databinding.ActivitySecundBinding
import com.example.musicplayer.utils.MYData
import com.example.musicplayer.utils.MYData.count
import com.example.musicplayer.utils.MYData.mediaPlayer

private const val TAG = "SecundActivity"

class SecundActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecundBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val position = intent.getIntExtra("key",0)
        if (MYData.count==0){
        mediaPlayer = MediaPlayer.create(this@SecundActivity, MYData.list[position].music)
        mediaPlayer!!.start()
            MYData.count+=1
        }else {
            mediaPlayer!!.pause()
            MYData.count=0
        }
        binding.seekbar.max = mediaPlayer!!.duration

        binding.seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaPlayer!!.seekTo(position)
                Log.d(TAG, "onProgressChanged: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d(TAG, "onStartTrackingTouch: ")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d(TAG, "onStopTrackingTouch: ")
            }
        })
        binding.play.setOnClickListener {
            if (mediaPlayer!!.isPlaying){
                mediaPlayer!!.pause()
                binding.play.setImageResource(R.drawable.play)
            }else{
                binding.play.setImageResource(R.drawable.pause)
                mediaPlayer!!.start()


            }
        }

        binding.close.setOnClickListener {
            mediaPlayer!!.stop()
            finish()
        }
    }
}