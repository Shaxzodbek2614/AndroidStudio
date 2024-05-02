package com.example.viewpagervazifa2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ModelAdapter(activity: MainActivity,var list:ArrayList<Model>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return BlankFragment().apply {
            arguments = Bundle().apply {
                val item = list[position]
                putInt("image",item.image)
                putString("name",item.name)
                putInt("position",position)
            }
        }
    }
}