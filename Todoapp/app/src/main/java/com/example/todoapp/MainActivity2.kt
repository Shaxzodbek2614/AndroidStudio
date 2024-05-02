package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.adapters.MySpinnerAdapter
import com.example.todoapp.databinding.ActivityMain2Binding
import com.example.todoapp.models.Model
import com.example.todoapp.models.MySpinner
import com.example.todoapp.utils.MySharedPrefernce

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    lateinit var userArray:ArrayList<MySpinner>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        MySharedPrefernce.init(this)

        val spinerAdapter = MySpinnerAdapter(userArray)
        binding.addSpiner.adapter = spinerAdapter

        binding.btnSave.setOnClickListener {
            val toDoName = binding.addName.text.toString().trim()
            val toDoDescription = binding.addDescription.text.toString().trim()
            val toDoCreateData = binding.createDate.text.toString().trim()
            val toDoDedline = binding.dedline.text.toString().trim()

            val degree = userArray[binding.addSpiner.selectedItemPosition]

            if (toDoName!="" && toDoCreateData!="" && toDoDedline!="" && toDoDescription!=""){
                val myList = MySharedPrefernce.list
                myList.add(Model(toDoName,toDoDescription,degree,toDoCreateData,toDoDedline,"Open"))
                MySharedPrefernce.list = myList
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Error because editText is empty", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun loadData() {
        userArray = ArrayList()
        userArray.add(MySpinner("To do deegre",-1))
        userArray.add(MySpinner("Urgent",R.drawable.red_flag))
        userArray.add(MySpinner("High",R.drawable.gray_flag))
        userArray.add(MySpinner( "Normal",R.drawable.blue_flag))
        userArray.add(MySpinner( "Low",R.drawable.red_flag))
    }
}