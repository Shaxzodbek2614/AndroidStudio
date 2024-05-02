package com.example.viewpagervazifa1.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagervazifa1.BlankFragment
import com.example.viewpagervazifa1.MainActivity
import com.example.viewpagervazifa1.R
import com.example.viewpagervazifa1.model.Model

class ModelAdapter(activity:MainActivity, private var list:ArrayList<Model>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return BlankFragment().apply {
            arguments = Bundle().apply {
                val item = list[position]
                putInt("image",item.img)
                putString("name",item.name)
                putString("deck",item.deck)
            }
        }
    }

}