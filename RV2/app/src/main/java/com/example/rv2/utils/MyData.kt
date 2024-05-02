package com.example.rv2.utils

import android.graphics.Color
import com.example.rv2.R
import com.example.rv2.models.Predment

object MyData {
    var list = ArrayList<Predment>()
    fun addPredment(){
        for (i in 0..20) {
            list.add(Predment(R.drawable.car, "AUTOMOTIVE", Color.parseColor("#F66132")))
            list.add(Predment(R.drawable.support, "CONSTRUCTION", Color.parseColor("#FFC107")))
            list.add(Predment(R.drawable.battery_status_full, "BATTERIES", Color.parseColor("#FF9800")))
            list.add(Predment(R.drawable.leaf, "GARDEN", Color.parseColor("#92C558")))
            list.add(Predment(R.drawable.flash, "ELECTRONIC", Color.parseColor("#FFE500")))
        }
    }
}