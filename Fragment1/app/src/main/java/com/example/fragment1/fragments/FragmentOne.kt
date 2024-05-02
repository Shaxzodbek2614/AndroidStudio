package com.example.fragment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment1.R
import com.example.fragment1.databinding.FragmentOneBinding


class FragmentOne : Fragment() {

    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(layoutInflater)
        binding.txt1.setOnClickListener {
            Toast.makeText(context, "Alik", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}