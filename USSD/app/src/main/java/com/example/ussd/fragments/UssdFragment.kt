package com.example.ussd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ussd.adapters.USSDAdapter
import com.example.ussd.databinding.FragmentUssdBinding
import com.example.ussd.models.USSD


class UssdFragment : Fragment() {
    private val binding by lazy { FragmentUssdBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ussdAdapter = USSDAdapter(context,loadData())
        binding.rvUssd.adapter = ussdAdapter
        return binding.root
    }

    fun loadData():ArrayList<USSD>{
        val list = ArrayList<USSD>()
        list.add(USSD("*102#","XISOBNI TEKSHIRISH","Xisobingizdagi qoldiqni ko'rish uchun ushbu kodni yuborishingiz mumkin."))
        list.add(USSD("*101#","MB QOLDIG'I (IJT.TARMOQ)","Ijtiomiy tarmoqlar uchun berilgan trafik qoldig'ini ko'rish uchun."))
        list.add(USSD("*103#","MB QOLDIG'I","Sotib olingan internet trafik paketlari,hamda bonus trafik qoldiqlarini ko'rish."))
        list.add(USSD("*109#","MB QOLDIG'I (TAS-IX)","Tas-ix tarmog'i ichida ishlatish uchun sotib olingan internet trafik paketlari qoldiqlari,hamda bonus trafik qoldiqlarini ko'rish."))
        list.add(USSD("*105#","SMSLAR QOLDIG'I","Xisobingizda qolgan bepul SMSlar haqida ma'lumot."))
        list.add(USSD("*106#","DAQIQLAR QOLDIG'I","Xisobingizda qolgan bepul daqiqalar haqida ma'lumot."))
        list.add(USSD("*148#","RAQAMNI ANIQLASH","SIM kartangizning telefon raqamini aniqlash uchun ushbu kodni yuboring."))
        list.add(USSD("*110*00#","DOLLAR KURSI"))
        list.add(USSD("*110*05#","TARIF REJAM","Xozirda qaysi tarif rejada bo'lganingizni tekshirish uchun ushbu kodni yuboring.Javobi SMS tariqasida keladi"))
        list.add(USSD("*110*09#","QO'SHIMCHA XIZMATLAR","Yoqilgan qo'shimcha xizmatlar r'yxatini ko'rish. Javobi SMS tariqasida keladi."))
        list.add(USSD("*303#","MENING RAQAMLARIM","Pasportingizga ro'yxatdan o'tgan hamma telefon raqamlarni ro'yxatini olish. Javobi SMS tariqasida keladi."))

        return list
    }
}