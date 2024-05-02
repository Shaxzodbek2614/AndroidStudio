package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import java.util.Random

class MainActivity : AppCompatActivity() {
    var number1 = 0
    var number2 = 0
    var javob = 0
    lateinit var txt1:TextView
   lateinit var btn :Button
    lateinit var edt :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById<TextView>(R.id.txt_tv)
        btn = findViewById(R.id.btn)
        edt = findViewById(R.id.edt)
        random()
        btn.setOnClickListener {
            if (edt.text.isNotEmpty()) {
                if (edt.text.toString().toInt() == javob) Toast.makeText(
                    this,
                    "To'g'ri",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
                edt.text.clear()
                random()
            }
        }

    }
    fun random(){
        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)
        javob = Random().nextInt(4)
        when(javob){
            0->{
                txt1.text = "$number1 + $number2"
                javob = number1+number2
            }
            1->{
                if (number1-number2>0) {
                    txt1.text = "$number1 - $number2"
                    javob = number1 - number2
                }else random()
            }
            2->{
                txt1.text = "$number1 * $number2"
                javob = number1*number2
            }
            3->{
               try {
                   if (number1%number2!=0) throw Exception()
                   txt1.text = "$number1 / $number2"
                   javob = number1/number2
               }catch (e:Exception){
                   random()
               }
            }
        }
    }
}