package com.example.unverstetda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unverstetda.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()

        val userAdapter = UserAdapter(this,list)
        binding.rv.adapter = userAdapter
        val myLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        binding.rv.apply {
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity, myLayoutManager.orientation))
        }

        val itemTouchHelper = ItemTouchHelper(object :MyTouchHelper(){
            override fun onItemSwapToDelete(position: Int) {
                var item = list.removeAt(position)
                userAdapter.notifyItemRemoved(position)

                Snackbar.make(this@MainActivity,binding.rv,"$item is going to be removed",Snackbar.LENGTH_LONG)
                    .setAction("Tiklash"){
                        list.add(position,item)
                        userAdapter.notifyItemInserted(position)
                    }.show()
            }

            override fun onItemMoved(from: Int, to: Int) {
                Collections.swap(list,from,to)
                userAdapter.notifyItemMoved(from,to)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.rv)
    }

    fun loadData(){
        list = ArrayList()
        for (i in 0..20){
            list.add("salom $i")
        }
    }
}