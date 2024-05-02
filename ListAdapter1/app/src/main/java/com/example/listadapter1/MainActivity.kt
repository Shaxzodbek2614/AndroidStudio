package com.example.listadapter1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listadapter1.adapter.UserAdapter
import com.example.listadapter1.databinding.ActivityMainBinding
import com.example.listadapter1.models.User

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<User>
    lateinit var userAdapter: UserAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        list = ArrayList()
        for (i in 0 until 100){
            list.add(User("Yaponiya","https://storage.kun.uz/source/thumbnails/_medium/10/TW6rUVQ07vunflmXX-NgrbxVU6CA6Sjo_medium.jpg"))
            list.add(User("Dayjest","https://storage.kun.uz/source/thumbnails/_medium/10/JxywSmzJDnMeQwIY_qFxAAGcjL7HlIrj_medium.jpg"))
        }



    }

    override fun onResume() {
        super.onResume()
        userAdapter = UserAdapter(object :UserAdapter.RvAction{
            override fun itemClick(user: User) {
                list.remove(user)
                onResume()
            }
        })
        binding.rv.adapter = userAdapter
        userAdapter.submitList(list)

    }
}