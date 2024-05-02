package com.example.viewpagervazifa1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.viewpagervazifa1.adapter.ModelAdapter
import com.example.viewpagervazifa1.databinding.ActivityMainBinding
import com.example.viewpagervazifa1.model.Model
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Model>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()

        val modelAdapter = ModelAdapter(this,list)
        binding.pager.adapter = modelAdapter
        TabLayoutMediator(binding.tablayout, binding.pager) { tab, position ->
        }.attach()
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding.btnOtkazish.setOnClickListener {
            binding.pager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
        binding.tablayout.background = null
    }

    fun loadData(){
        list = ArrayList()
        list.add(
            Model(R.drawable.page1,"Xush kelibsiz",
                "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                        "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘")
        )
        list.add(
            Model(R.drawable.page2,"Hikoyalar dunyosi",
                "Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                        "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! ")
        )
        list.add(
            Model(R.drawable.page3,"Kitob ortidan..",
                "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                        " Kelmadi jonimg'a hech oromi jondin yaxshilig'.")
        )
        list.add(
            Model(R.drawable.page4,"Bizga qo`shiling",
                "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                        " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?")
        )
    }
}