package com.example.ussd.fragments

import InternetAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ussd.databinding.FragmentInternetBinding
import com.example.ussd.models.Internet
import com.example.ussd.utils.MyData


class InternetFragment : Fragment() {
    lateinit var internetAdapter: InternetAdapter
    private val binding by lazy { FragmentInternetBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (MyData.count==1) {
            internetAdapter = InternetAdapter(context, loadData())
            binding.rvInternet.adapter = internetAdapter
        }else if (MyData.count==2){
            internetAdapter = InternetAdapter(context, smsData())
            binding.rvInternet.adapter = internetAdapter
        }
        return binding.root
    }

    private fun loadData():ArrayList<Internet>{
        val list = ArrayList<Internet>()

        list.add(Internet("1 GB","10000 so'm","30 kun","*1*01*8116#"))
        list.add(Internet("2 GB","15000 so'm","30 kun","*1*02*8116#"))
        list.add(Internet("5 GB","25000 so'm","30 kun","*1*05*8116#"))
        list.add(Internet("10 GB","45000 so'm","30 kun","*1*10*8116#"))
        list.add(Internet("20 GB","65000 so'm","30 kun","*1*20*8116#"))
        list.add(Internet("30 GB","75000 so'm","30 kun","*1*30*8116#"))
        list.add(Internet("50 GB","90000 so'm","30 kun","*1*50*8116#"))
        list.add(Internet("75 GB","110000 so'm","30 kun","*1*75*8116#"))
        list.add(Internet("150 GB","110000 so'm","30 kun","*1*150*8116#"))
        list.add(Internet("4G Hafta","30000 so'm","7 kun","*110*62#"))
        list.add(Internet("1,5 GB","10000 so'm","7 kun","*1*0*5#"))
        list.add(Internet("2,5 GB","15000 so'm","7 kun","*1*0*6#"))
        list.add(Internet("5 GB","20000 so'm","7 kun","*1*0*7#"))
        list.add(Internet("4G Kun","10000 so'm","1 kun","*110*58#"))
        list.add(Internet("100 MB","2000 so'm","1 kun","*1*0*1#"))
        list.add(Internet("200 MB","3000 so'm","1 kun","*1*0*2#"))
        list.add(Internet("500 MB","5000 so'm","1 kun","*1*0*3#"))
        list.add(Internet("4 GB","10000 so'm","1 kun","*1*0*4#"))

        return list
    }

    private fun smsData():ArrayList<Internet>{
        val list = ArrayList<Internet>()
        list.add(Internet("20 SMS","500 so'm","1 kun","*110*161#"))
        list.add(Internet("50 SMS","1000 so'm","1 kun","*110*162#"))
        list.add(Internet("250 SMS","1300 so'm","1 kun","*110*151#"))
        list.add(Internet("100 SMS","5263 so'm","30 kun","*110*044#"))
        list.add(Internet("500 SMS","13683 so'm","30 kun","*110*045#"))
        list.add(Internet("1000 SMS","22103 so'm","30 kun","*110*046#"))


        return list
    }

}