package com.example.mohirdevalertdialog

import android.content.DialogInterface
import android.content.DialogInterface.OnMultiChoiceClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mohirdevalertdialog.databinding.ActivityMainBinding
import com.example.mohirdevalertdialog.databinding.CostomBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var count = 0
    private val isChekedArray = BooleanArray(3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val customBinding = CostomBinding.inflate(layoutInflater,null,false)
            val dialog = AlertDialog.Builder(this)
                .setView(customBinding.root)
                .create()
            customBinding.btnCustom.setOnClickListener {
                Toast.makeText(this, "${customBinding.name.text}, ${customBinding.email.text}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialog.show()
        }
    }
}