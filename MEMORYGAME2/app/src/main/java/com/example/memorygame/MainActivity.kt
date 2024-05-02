package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.memorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val listImageOchiqYopiq = arrayOf(false,false,false,false,false,false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false
   private lateinit var binding: ActivityMainBinding
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
        binding.image4.setOnClickListener {
            imageClick(binding.image4,R.drawable.img_1,3)
        }
        binding.image5.setOnClickListener {
            imageClick(binding.image5,R.drawable.img_2,4)
        }
        binding.image6.setOnClickListener {
            imageClick(binding.image6,R.drawable.img_3,5)
        }
    }

    fun imageClick(imageView: ImageView,rasm: Int,index: Int){
        if (!animationDoing) {
            if (listImageOchiqYopiq[index] == false) {
                imageOchilish(imageView, rasm, index)
            } else {
                imageYopilish(imageView, rasm, index)
            }
        }
    }

    fun imageOchilish(imageView: ImageView, rasm:Int, index:Int){
         val animation = AnimationUtils.loadAnimation(this,R.anim.anim_1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImageOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++
                        if (ochiqRasm==2){
                            if (rasmId[0] == rasmId[1]){
                                imageViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                            }else{
                                imageYopilish(imageViewAniqla(imageIndex[0]),-1,imageIndex[0])
                                imageYopilish(imageViewAniqla(imageIndex[1]),-1,imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

    }
    fun imageYopilish(imageView: ImageView, rasm:Int, index:Int?){
        val animation = AnimationUtils.loadAnimation(this,R.anim.anim_1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.star)
                animation2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        listImageOchiqYopiq[index!!] = false
        ochiqRasm--
    }

    fun imageViewAniqla(index: Int?):ImageView{
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