package com.example.musicplayer.utils

import android.media.MediaPlayer
import com.example.musicplayer.R
import com.example.musicplayer.models.Music

object MYData {
    var list = ArrayList<Music>()
    fun addMusic(){
        for (i in 0 until 10){
            list.add(Music("Freeman","Low", R.raw.music1))
            list.add(Music("Moneyken","Love",R.raw.music2))
            list.add(Music("Kimdur","Get lucky",R.raw.music3))
        }
    }

    var mediaPlayer: MediaPlayer? =null
    var count = 0

}