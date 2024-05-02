package com.example.testgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
   lateinit var txt :TextView
    lateinit var rad_group :RadioGroup
    lateinit var rad_a :RadioButton
    lateinit var rad_b :RadioButton
    lateinit var rad_c:RadioButton
    lateinit var rad_d:RadioButton
   lateinit var btn:Button
    var javob = 0
    var random1 = 0
    var random2 = 0
    var random3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById<TextView>(R.id.txt_tv)
        rad_group = findViewById<RadioGroup>(R.id.rad_group)
        rad_a = findViewById<RadioButton>(R.id.rad_a)
        rad_b = findViewById<RadioButton>(R.id.rad_b)
        rad_c = findViewById<RadioButton>(R.id.rad_c)
        rad_d = findViewById<RadioButton>(R.id.rad_d)
        btn = findViewById<Button>(R.id.btn)
        random()
        btn.setOnClickListener {
            if (rad_a.isChecked){
                if (rad_a.text.toString().toInt()==javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT)
                    .show()
                else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }else if (rad_b.isChecked){
                if (rad_b.text.toString().toInt()==javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT)
                    .show()
                else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }else if (rad_c.isChecked){
                if (rad_c.text.toString().toInt()==javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT)
                    .show()
                else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }else if (rad_d.isChecked){
                if (rad_a.text.toString().toInt()==javob) Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT)
                    .show()
                else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
            }
            rad_group.clearCheck()
            random()
        }
    }

    @SuppressLint("SetTextI18n")
    fun random(){
        val number1 = Random().nextInt(20)
        val number2 = Random().nextInt(20)
        val amal = Random().nextInt(4)
        when(amal){
            0->{
                txt.text= "$number1 + $number2"
                javob = number1+number2
            }
            1->{
                if (number1-number2>0) {
                    txt.text = "$number1 - $number2"
                    javob = number1 - number2
                }else random()
            }
            2->{
                txt.text= "$number1 * $number2"
                javob = number1*number2
            }
            3->{
                if (number1%number2==0) {
                    txt.text = "$number1 / $number2"
                    javob = number1 / number2
                }else random()
            }
        }
        randomShow()
    }

    fun randomSonAniqla(){
        random1 = Random().nextInt(20)
        random2 = Random().nextInt(20)
        random3 = Random().nextInt(20)
        if (random1==random2 || random2==random3 || random1==random3 || random1==javob || random2==javob ||javob==random3){
            randomSonAniqla()
        }
    }

    fun randomShow(){
        val tj = Random().nextInt(4)
        randomSonAniqla()
        when(tj){
            0->{
                rad_a.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            1->{
                rad_b.text = javob.toString()
                rad_a.text = random1.toString()
                rad_c.text = random2.toString()
                rad_d.text = random3.toString()
            }
            2->{
                rad_c.text = javob.toString()
                rad_b.text = random1.toString()
                rad_a.text = random2.toString()
                rad_d.text = random3.toString()
            }
            3->{
                rad_d.text = javob.toString()
                rad_b.text = random1.toString()
                rad_c.text = random2.toString()
                rad_a.text = random3.toString()
            }
        }
    }
}