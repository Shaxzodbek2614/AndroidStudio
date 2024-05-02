package com.example.draganddrop

import androidx.appcompat.app.AppCompatActivity
import com.example.draganddrop.databinding.ItemRvBinding
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ActionMenuView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.draganddrop.adapter.ModelAdapter
import com.example.draganddrop.databinding.ActivityMainBinding
import com.example.draganddrop.models.Model
import com.example.draganddrop.utils.MyData

class MainActivity : AppCompatActivity() {
    private lateinit var modelAdapter: ModelAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addModel()

        modelAdapter = ModelAdapter(this@MainActivity,MyData.list)
        binding.rv.adapter = modelAdapter


        val languages = resources.getStringArray(R.array.Languages)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, getString(R.string.selected_item) + " " + "" + languages[position], Toast.LENGTH_SHORT).show()
                MyData.count = position
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
        binding.add.setOnClickListener {
            MyData.list.add(1,Model(R.drawable.chip,"New added item"))
            modelAdapter.notifyItemChanged(1)

        }

        binding.del.setOnClickListener {
            MyData.list.removeAt(1)
            modelAdapter.notifyItemRemoved(1)
            MyData.delete = false

        }
    }

}