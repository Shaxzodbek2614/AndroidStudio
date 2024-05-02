package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var images = arrayOf(R.drawable.images,R.drawable.images1,R.drawable.images2)
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnNext).setOnClickListener{
            if (count<images.count()-1){
                count++
                setImage()
            }else if (count==2){
                Toast.makeText(this,"Rasmlar tugadi",Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            if (count>0){
                count--
                setImage()
            }else if (count==0){
                Toast.makeText(this,"Rasmlar oldinda",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setImage(){
        findViewById<ImageView>(R.id.imageView).setImageResource(images[count])
        findViewById<TextView>(R.id.tvImage).text = "${count+1} - Rasm"
    }
}