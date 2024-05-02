package com.example.fragment18

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment18.MyData.count
import com.example.fragment18.databinding.FragmentSekundBinding


class SekundFragment : Fragment() {

    lateinit var binding: FragmentSekundBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSekundBinding.inflate(layoutInflater)
        binding.apply {
            color1.setOnClickListener {
                Toast.makeText(context, "Color1 bosildi", Toast.LENGTH_SHORT).show()
                count = 1
            }
            color2.setOnClickListener {
                Toast.makeText(context, "Color2 bosildi", Toast.LENGTH_SHORT).show()
                count = 2
            }
            color3.setOnClickListener {
                Toast.makeText(context, "Color3 bosildi", Toast.LENGTH_SHORT).show()
                count = 3
            }
            color4.setOnClickListener {
                Toast.makeText(context, "Color4 bosildi", Toast.LENGTH_SHORT).show()
                count = 4
            }
            color5.setOnClickListener {
                Toast.makeText(context, "Color5 bosildi", Toast.LENGTH_SHORT).show()
                count = 5
            }
            color6.setOnClickListener {
                Toast.makeText(context, "Color6 bosildi", Toast.LENGTH_SHORT).show()
                count = 6
            }
            color7.setOnClickListener {
                Toast.makeText(context, "Color7 bosildi", Toast.LENGTH_SHORT).show()
                count = 7
            }
            color8.setOnClickListener {
                Toast.makeText(context, "Color8 bosildi", Toast.LENGTH_SHORT).show()
                count = 8
            }
            color9.setOnClickListener {
                Toast.makeText(context, "Color9 bosildi", Toast.LENGTH_SHORT).show()
                count = 9
            }
            color10.setOnClickListener {
                Toast.makeText(context, "Color10 bosildi", Toast.LENGTH_SHORT).show()
                count = 10
            }
            color11.setOnClickListener {
                Toast.makeText(context, "Color11 bosildi", Toast.LENGTH_SHORT).show()
                count = 11
            }
            color12.setOnClickListener {
                Toast.makeText(context, "Color12 bosildi", Toast.LENGTH_SHORT).show()
                count = 12
            }
        }
        return binding.root
    }

}