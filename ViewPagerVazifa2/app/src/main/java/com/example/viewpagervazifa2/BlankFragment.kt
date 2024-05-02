package com.example.viewpagervazifa2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagervazifa2.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private val binding by lazy { FragmentBlankBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.apply {
            binding.image.setImageResource(getInt("image"))
            binding.name.text = getString("name")
        }
        val position = arguments?.getInt("position",0)

    }

}