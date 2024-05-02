package com.example.draganddrop.utils

import android.content.Context
import android.view.animation.AnimationUtils
import com.example.draganddrop.R
import com.example.draganddrop.models.Model

object MyData {
    var list = ArrayList<Model>()
    fun addModel(){
        for (i in 0 until 10){
            list.add(Model(R.drawable.chip,"New added item"))
        }
    }
    var count = 0
    var delete = true
}