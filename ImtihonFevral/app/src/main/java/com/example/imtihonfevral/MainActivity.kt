package com.example.imtihonfevral

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.imtihonfevral.adapter.UserAdapter
import com.example.imtihonfevral.databinding.ActivityMainBinding
import com.example.imtihonfevral.model.User
import com.example.imtihonfevral.utils.MySharedPreference
import java.util.Random

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPreference.init(this)

        var list = MySharedPreference.list
        userAdapter = UserAdapter(this,list)
        binding.rv.adapter = userAdapter

        binding.btnSave.setOnClickListener {
            if (binding.name.text.isEmpty() || binding.address.text.isEmpty()){
                Toast.makeText(this, "Bo'limlardan biri bo'sh", Toast.LENGTH_SHORT).show()
            }else{
                val seriya = randomSon()
                val user = User(binding.name.text.toString(),
                    binding.address.text.toString(),
                    seriya)
                list.add(user)
                MySharedPreference.list = list
                hideKeyboard()
                userAdapter.notifyItemInserted(list.size-1)
                binding.name.text.clear()
                binding.address.text.clear()
                Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
            }

        }


    }
    fun randomSon():String{
        val str = "ABC"
        val a = Random().nextInt(3)
        var seriya = "A${str[a]} "
        for (i in 1..7){
            val random = Random().nextInt(10)
            seriya+=random.toString()
        }
        val list  = MySharedPreference.list
        for (user in list) {
            if (user.seria==seriya){
                seriya = ""
                randomSon()
                break
            }
        }

        return seriya
    }
    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}