package com.example.rv1.utils

import com.example.rv1.Models.Movie
import com.example.rv1.R

object Mydata {
    var list = ArrayList<Movie>()
    var count = 1
    fun addMovies(){
        for (i in 0 until 10){
            list.add(Movie(R.drawable.img,"Avanger","Views: 500","Release Date:16 Feb 2018"))
            list.add(Movie(R.drawable.img_1,"Jahon urushi Z","Views: 600","Release Date:18 March 2018"))
            list.add(Movie(R.drawable.img_2,"Yura davri","Views: 400","Release Date:25 Feb 2018"))
            list.add(Movie(R.drawable.img_3,"Collection","Views: 700","Release Date:15 Jan 2018"))
        }
    }
}