package com.example.ussd.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ussd.R
import com.example.ussd.databinding.FragmentHomeBinding
import com.example.ussd.utils.MyData


class HomeFragment : Fragment() {
   private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.card1.setOnClickListener {
            findNavController().navigate(R.id.internetFragment)
            MyData.count=1
        }

        binding.card3.setOnClickListener {
            findNavController().navigate(R.id.callFragment)
        }
        binding.card5.setOnClickListener {
            findNavController().navigate(R.id.internetFragment)
            MyData.count=2
        }
        binding.card6.setOnClickListener {
            findNavController().navigate(R.id.ussdFragment)
        }
        binding.card4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://beeline.uz/uz/events/category/actions"))
            startActivity(intent)
        }
        binding.card2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://beeline.uz/uz/products/tariffs"))
            startActivity(intent)
        }
        return binding.root
    }


}