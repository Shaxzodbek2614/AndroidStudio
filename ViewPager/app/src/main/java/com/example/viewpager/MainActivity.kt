package com.example.viewpager

import DepthPageTransformer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager.adapter.ModelAdapter
import com.example.viewpager.databinding.ActivityMainBinding
import com.example.viewpager.models.Model

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
        binding.viewPager.setPageTransformer(true, DepthPageTransformer())
    }

    fun loadData(){
        list = ArrayList()
        list.add(Model("Salim Abduvaliyev","https://storage.kun.uz/source/thumbnails/_medium/10/OdyheU9E9R-WuviYc9SOR5MBVGT-KMBA_medium.jpg"))
        list.add(Model("O'zbekneftgaz","https://storage.kun.uz/source/thumbnails/_medium/10/QEpWMcS-OCCe72PasfiEpElwCXk4scsm_medium.jpg"))
        list.add(Model("Siyosiy monopoliya","https://storage.kun.uz/source/thumbnails/_medium/10/bVwnwu4pnQc3IFuWO9QCNdmHqWb-YiOc_medium.jpg"))
    }
}