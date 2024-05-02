package com.example.smssherlar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.smssherlar.MyData.MyData
import com.example.smssherlar.R
import com.example.smssherlar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private val binding by lazy {FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.card3.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=0
        }
        binding.card4.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=1
        }
        binding.card5.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=2
        }
        binding.card6.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=3
        }
        binding.card7.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=4
        }
        binding.card8.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=5
        }
        binding.card2.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
            MyData.count=6
        }
        return binding.root
    }


}