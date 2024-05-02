package com.example.mathgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var txtSavol:TextView
    lateinit var edtJavob:EditText
    lateinit var btnOk:Button
    var number1 = 0
    var number2 = 0
    var amal = 0
    var javob = 0
    var kirjavob = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtSavol = findViewById(R.id.txt_savol)
        edtJavob = findViewById(R.id.edt_javob)
        btnOk = findViewById(R.id.btn_ok)

        random()
        ekrangaChiqar()

        btnOk.setOnClickListener {
            kirjavob = edtJavob.text.toString().toInt()
            if (kirjavob==javob){
                Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
            }else Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()

            random()
        }

    }
    fun random(){
        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)
        amal = Random().nextInt(4)

        ekrangaChiqar()
    }

    fun ekrangaChiqar(){
        random()
        when(amal){
            0->{
                javob = number1+number2
                txtSavol.text = "$number1 + $number1"
            }
            1->{
                javob = number1-number2
                txtSavol.text = "$number1 - $number2"
            }
            2->{
                try {
                     if (number1%number2==0){
                         javob = number1/number2
                         txtSavol.text = "$number1 / $number2"
                     }else random()
                }catch (e:Exception){
                    random()
                }
            }
            3->{
                javob = number1*number2
                txtSavol.text = "$number1 * $number2"
            }
        }
    }

}