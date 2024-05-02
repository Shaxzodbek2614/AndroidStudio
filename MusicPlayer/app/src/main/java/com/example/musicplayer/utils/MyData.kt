package com.example.musicplayer.utils

import android.media.MediaParser
import android.media.MediaPlayer
import android.provider.MediaStore.Audio.Media
import com.example.musicplayer.R
import com.example.musicplayer.models.Music

object MyData {
    var list = ArrayList<Music>()
    fun addMusic(){
        for (i in 0 until 10) {
            list.add(Music("Freman", "Low", R.raw.music1))
            list.add(Music("Monekey", "Love", R.raw.music2))
        }
    }
    var count = true
}