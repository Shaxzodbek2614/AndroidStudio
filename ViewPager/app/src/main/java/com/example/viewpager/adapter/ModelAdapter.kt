package com.example.viewpager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpager.R
import com.example.viewpager.models.Model
import com.squareup.picasso.Picasso

class ModelAdapter(var list:ArrayList<Model>):PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPager = LayoutInflater.from(container.context).inflate(R.layout.item_pager,container,false)

        val image = itemPager.findViewById<ImageView>(R.id.image)
        Picasso.get().load(list[position].imageLink).into(image)

        itemPager.findViewById<TextView>(R.id.text).text = list[position].name
        container.addView(itemPager,position)
        return itemPager
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }
}