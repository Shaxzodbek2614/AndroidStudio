package com.example.smssherlar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smssherlar.MyData.MyData
import com.example.smssherlar.R
import com.example.smssherlar.adapters.SherlarAdapter
import com.example.smssherlar.databinding.FragmentSecondBinding
import com.example.smssherlar.databinding.ItemDialogBinding
import com.example.smssherlar.databinding.ItemRvBinding
import com.example.smssherlar.models.Sher
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match

class SecondFragment : Fragment() {
   private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }

    lateinit var sherlarAdapter: SherlarAdapter
    var listSaved = ArrayList<Sher>()
    var list1=ArrayList<Sher>()
    var list2=ArrayList<Sher>()
    var list3=ArrayList<Sher>()
    var list4=ArrayList<Sher>()
    var list5=ArrayList<Sher>()
    var list6=ArrayList<Sher>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MyData.addSher()
        aniqla()
        when(MyData.count){
            0->{
                binding.title.text = "SEVGI\nSHE'RLARI"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
                        val itemRvBinding = ItemRvBinding.inflate(layoutInflater)
                        itemDialogBinding.nameDialog.text = list1[position].name
                        itemDialogBinding.deckDialog.text = list1[position].deck
                        if (MyData.list[position].like==true){
                            MyData.list[position].like=true
                        }else MyData.list[position].like=false
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(itemDialogBinding.root)
                        bottomSheetDialog.show()
                    }
                },context,list1)
            }
            1->{
                binding.title.text = "SOG'INCH\nARMON"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list2)
            }
            2->{
                binding.title.text = "TABRIK\nSHE'RLARI"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list3)
            }
            3->{
                binding.title.text = "OTA-ONA\nHAQIDA"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list4)
            }
            4->{
                binding.title.text = "DO'STLIK\nSHE'RLARI"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list5)
            }
            5->{
                binding.title.text = "HAZIL\nSHE'RLARI"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list6)
            }
            6->{
                binding.title.text = "SAQLANGAN\nSHE'RLARI"
                sherlarAdapter = SherlarAdapter(object :SherlarAdapter.RvAction{
                    override fun onClick(position: Int) {
                        val bottomSheetDialog = BottomSheetDialog(context!!,R.style.NewDialog)
                        bottomSheetDialog.setContentView(layoutInflater.inflate(R.layout.item_dialog, null, false))
                        bottomSheetDialog.show()
                    }
                },context,list6)
            }
        }
        binding.rv.adapter = sherlarAdapter
        binding.qaytish.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root
    }

    fun aniqla(){
        val list = MyData.list
        for (sher in list) {
            when(sher.tanla){
                0->list1.add(sher)
                1->list2.add(sher)
                2->list3.add(sher)
                3->list4.add(sher)
                4->list5.add(sher)
                5->list6.add(sher)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MyData.list.clear()
    }



}