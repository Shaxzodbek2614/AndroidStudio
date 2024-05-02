package com.example.todoapp


import android.content.Intent
import android.graphics.ColorSpace.Model
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todoapp.adapters.ExpandableAdapter
import com.example.todoapp.databinding.ActivityToDoListBinding
import com.example.todoapp.utils.MySharedPrefernce


class ToDoList : AppCompatActivity(){
    private val binding by lazy { ActivityToDoListBinding.inflate(layoutInflater) }
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList:ArrayList<String>

    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        MySharedPrefernce.init(this)
//        keshdanArrayga()

        binding.expandable.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, ChildActivity::class.java)
            intent.putExtra("name", map[titleList[groupPosition]]?.get(childPosition))
            startActivity(intent)
            true
        }
    }


    private fun keshdanArrayga() {
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        var planArray = ArrayList<com.example.todoapp.models.Model>()
        planArray = MySharedPrefernce.list
        for (todoPlan in planArray) {
            if (todoPlan.level == "Open"){
                openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Development"){
                developmentArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Uploading"){
                uploadingArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Reject"){
                rejectArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Close"){
                closedArray.add(todoPlan.name)
            }
        }


        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray

    }


    override fun onStart() {
        super.onStart()
        MySharedPrefernce.init(this)
        keshdanArrayga()
        Log.i("axborot", "onStart metodi")
        val spinerAdapter1 = ExpandableAdapter(titleList,map)
        binding.expandable.setAdapter(spinerAdapter1)

    }
}