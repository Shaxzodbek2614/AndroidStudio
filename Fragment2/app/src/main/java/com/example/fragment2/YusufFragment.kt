package com.example.fragment2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment2.databinding.FragmentShukurBinding
import com.example.fragment2.databinding.FragmentYusufBinding


class YusufFragment : Fragment() {
    private lateinit var binding:FragmentYusufBinding
    var sharedString:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedString = arguments?.getString("key")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYusufBinding.inflate(layoutInflater)

        binding.txtView.text = sharedString
        return binding.root
    }
}