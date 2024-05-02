package com.example.misol

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginStart
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linerLayout = LinearLayout(this)
        linerLayout.orientation = LinearLayout.VERTICAL
        linerLayout.gravity = Gravity.CENTER
        linerLayout.setBackgroundColor(Color.GREEN)

//        val txt = TextView(this)
//        txt.text = "ON"
//        txt.textSize = 30f
//        txt.setTextColor(Color.BLACK)
//        txt.gravity = Gravity.CENTER
//        linerLayout.addView(txt)

        val image = ImageView(this)
        image.setImageResource(R.drawable.solution)
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        image.layoutParams = LinearLayout.LayoutParams(400,400)
        linerLayout.addView(image)

        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
        setContentView(linerLayout,layoutParams)

        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        linerLayout.setOnTouchListener { v, event ->
            val action = event.action
            when(action){

                MotionEvent.ACTION_DOWN -> {
                    try {
                        cameraManager.setTorchMode(cameraId,true)
                        image.setImageResource(R.drawable.solution_lite)
                        linerLayout.setBackgroundColor(Color.RED)
                    }catch (e:CameraAccessException){
                    }
                }


                MotionEvent.ACTION_UP -> {
                    try {
                        cameraManager.setTorchMode(cameraId,false)
                        image.setImageResource(R.drawable.solution)
                        linerLayout.setBackgroundColor(Color.GREEN)
                    }catch (e:CameraAccessException){
                    }
                }
            }
            true
        }
    }

}