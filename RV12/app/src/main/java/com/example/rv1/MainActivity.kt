package com.example.rv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rv1.Adapter.MovieAdapter
import com.example.rv1.databinding.ActivityMainBinding
import com.example.rv1.utils.Mydata

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Mydata.addMovies()

        movieAdapter = MovieAdapter(this,Mydata.list)
        binding.rv.adapter = movieAdapter

        binding.btn.setOnClickListener {
            Mydata.count++
            if (Mydata.count==3) Mydata.count=1
            binding.btn.text = Mydata.count.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Mydata.list.clear()
    }

}