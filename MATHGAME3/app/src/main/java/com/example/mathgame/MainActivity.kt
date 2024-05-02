package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.mathgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val listOchiqYopiq = arrayOf(false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.image1.setOnClickListener {
            imageClick(binding.image1,R.drawable.img_1,0)
        }
        binding.image2.setOnClickListener {
            imageClick(binding.image2,R.drawable.img_2,1)
        }
        binding.image3.setOnClickListener {
            imageClick(binding.image3,R.drawable.img_3,2)
        }
    }
    fun imageClick(imageView: ImageView,rasm:Int, index:Int){
        if (listOchiqYopiq[index]==false){
            animatsiyaOchilishi(imageView,rasm,index)
        }else{
            animatsiyaYopilishi(imageView,rasm,index)
        }
    }
    fun animatsiyaOchilishi(imageView: ImageView, rasm: Int,index: Int){
        val animation = AnimationUtils.loadAnimation(this,R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity,R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++

                        if (ochiqRasm==2){
                            if (rasmId[0]==rasmId[1]){
                                imageAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                imageAniqla(imageIndex[1]).visibility = View.INVISIBLE
                            }else{
                                animatsiyaYopilishi(imageAniqla(imageIndex[0]),-1,imageIndex[0])
                                animatsiyaYopilishi(imageAniqla(imageIndex[1]),-1,imageIndex[1])
                            }
                        }
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        listOchiqYopiq[index] = true
        imageIndex[ochiqRasm] = index
        rasmId[ochiqRasm] = rasm
        ochiqRasm++

        if (ochiqRasm==2){
            if (rasmId[0]==rasmId[1]){
                imageAniqla(imageIndex[0]).visibility = View.INVISIBLE
                imageAniqla(imageIndex[1]).visibility = View.INVISIBLE
            }else{
                animatsiyaYopilishi(imageAniqla(imageIndex[0]),-1,imageIndex[0])
                animatsiyaYopilishi(imageAniqla(imageIndex[1]),-1,imageIndex[1])
            }
        }
    }

    fun animatsiyaYopilishi(imageView: ImageView,rasm: Int,index: Int?){
        val animation = AnimationUtils.loadAnimation(this,R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity,R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.img)

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        listOchiqYopiq[index!!] = false
        ochiqRasm--
    }

    fun imageAniqla(index: Int?):ImageView{
        var imageView:ImageView? = null
        when(index){
            0->imageView = binding.image1
            1->imageView = binding.image2
            2->imageView = binding.image3
            3->imageView = binding.image4
            4->imageView = binding.image5
            5->imageView = binding.image6
        }
        return imageView!!
    }
}