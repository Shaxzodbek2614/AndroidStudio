package com.example.fragment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment1.R
import com.example.fragment1.databinding.FragmentFagment2Binding


class Fagment2 : Fragment() {
    lateinit var binding: FragmentFagment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFagment2Binding.inflate(layoutInflater)

        binding.txt2.setOnClickListener {
            Toast.makeText(context, "Yaxshiman", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}