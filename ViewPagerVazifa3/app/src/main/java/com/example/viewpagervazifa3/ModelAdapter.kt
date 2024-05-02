package com.example.viewpagervazifa3

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ModelAdapter(activity: MainActivity,val list:ArrayList<Model>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return FirstFragment().apply {
            arguments = Bundle().apply {
                val item = list[position]
                putInt("image",item.image)
                putString("name",item.name)
                putString("deck",item.deck)
            }
        }
    }
}