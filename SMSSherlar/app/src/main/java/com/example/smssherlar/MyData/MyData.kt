package com.example.smssherlar.MyData

import com.example.smssherlar.models.Sher

object MyData {
    val list = ArrayList<Sher>()
    fun addSher(){
        for (i in 1..10){
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",0))
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",1))
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",2))
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",3))
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",4))
            list.add(Sher("Oshiq derlar meni","Sizni birinchi bor ko’rganimdayoq menga yoqib\n" +
                    "qolgansiz, lekin bu tuyg’u sevgiga aylanadi deb\n" +
                    "o’ylamagandim . . . ",5))
        }


    }
    var count = 0
}