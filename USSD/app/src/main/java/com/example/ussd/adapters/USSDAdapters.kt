package com.example.ussd.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.databinding.UssdItemBinding
import com.example.ussd.models.USSD

class USSDAdapter(var context: Context?, var list:ArrayList<USSD>): RecyclerView.Adapter<USSDAdapter.Vh>() {
    inner class Vh(var ussdItemBinding: UssdItemBinding):RecyclerView.ViewHolder(ussdItemBinding.root){
        fun onBind(ussd: USSD, position: Int){
            ussdItemBinding.name.text = ussd.kodi
            ussdItemBinding.turi.text = ussd.turi
            ussdItemBinding.deck.text = ussd.deck
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(UssdItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}