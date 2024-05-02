package com.example.fragment18

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment18.MyData.count
import com.example.fragment18.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        val sekundFragment = SekundFragment()
        binding.btnEdit.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment1,sekundFragment)
                .addToBackStack(null)
                .commit()
        }

        when(count){
            1->binding.root.setBackgroundColor(Color.parseColor("#E91E63"))
            2->binding.root.setBackgroundColor(Color.parseColor("#FFEB3B"))
            3->binding.root.setBackgroundColor(Color.parseColor("#4CAF50"))
            4->binding.root.setBackgroundColor(Color.parseColor("#009688"))
            5->binding.root.setBackgroundColor(Color.parseColor("#3F51B5"))
            6->binding.root.setBackgroundColor(Color.parseColor("#2196F3"))
            7->binding.root.setBackgroundColor(Color.parseColor("#673AB7"))
            8->binding.root.setBackgroundColor(Color.parseColor("#9C27B0"))
            9->binding.root.setBackgroundColor(Color.parseColor("#FF5722"))
            10->binding.root.setBackgroundColor(Color.parseColor("#FFC107"))
            11->binding.root.setBackgroundColor(Color.parseColor("#00BCD4"))
            12->binding.root.setBackgroundColor(Color.BLACK)
        }
        return binding.root
    }

}