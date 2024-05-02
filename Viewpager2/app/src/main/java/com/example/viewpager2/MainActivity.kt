package com.example.viewpager2

import DepthPageTransformer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.viewpager.models.Model
import com.example.viewpager2.adapter.ModelAdapter
import com.example.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var modelAdapter: ModelAdapter
    lateinit var list:ArrayList<Model>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        modelAdapter = ModelAdapter(list)
        binding.viewPager.adapter = modelAdapter
        binding.myTabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.setPageTransformer(true, DepthPageTransformer())
        setTabLayout()
    }

    private fun setTabLayout() {
        val tabCount = binding.myTabLayout.tabCount
        for (i in 0 until tabCount){
            val tabView = layoutInflater.inflate(R.layout.item_tab,null,false)
            val tab = binding.myTabLayout.getTabAt(i)
            tab?.customView = tabView
            val imageView = tabView.findViewById<ImageView>(R.id.item_tab_img)
            val textView = tabView.findViewById<TextView>(R.id.item_tab_txt)
            if (i==0){
                imageView.visibility = View.VISIBLE
            }else{
                imageView.visibility = View.GONE
            }

            textView.text = list[i].name
        }

        binding.myTabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                    customView?.findViewById<ImageView>(R.id.item_tab_img)?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.item_tab_img)?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    fun loadData(){
        list = ArrayList()
        list.add(Model("Salim Abduvaliyev","https://storage.kun.uz/source/thumbnails/_medium/10/OdyheU9E9R-WuviYc9SOR5MBVGT-KMBA_medium.jpg"))
        list.add(Model("O'zbekneftgaz","https://storage.kun.uz/source/thumbnails/_medium/10/QEpWMcS-OCCe72PasfiEpElwCXk4scsm_medium.jpg"))
        list.add(Model("Siyosiy monopoliya","https://storage.kun.uz/source/thumbnails/_medium/10/bVwnwu4pnQc3IFuWO9QCNdmHqWb-YiOc_medium.jpg"))
    }
}