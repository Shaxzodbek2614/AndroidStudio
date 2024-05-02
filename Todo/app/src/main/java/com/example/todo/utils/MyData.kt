package com.example.todo.utils

import com.example.todo.models.KompInfo

object MyData {
    val title = arrayListOf<String>("Mobiles","Laptops","Computer Accessories","Movies","Tvs by brand")
    val map = HashMap<String,ArrayList<KompInfo>>()
    fun addModel(){
        title
        val list = ArrayList<KompInfo>()
        list.add(KompInfo("Mi","Xiaomi xususiy kompaniya bo'lib, u smartfonlar, Android operatsion tizimi va boshqa maishiy elektronikalarni loyihalash, ishlab chiqish va sotish bilan shug'ullanadi. Xiaomi shuningdek, fitnes-trekerlar, televizorlar, havo tozalagichlar va planshetlar ishlab chiqaradi. Uning Android telefonlari va planshetlari uchun jild mavjud - MIUI"))
        list.add(
            KompInfo(
                "Samsung",
                "Samsung telefonlarining ko'p yonalishi bor va har yili yangi model chiqadi. Bu telefonlar ommabop bo'lgan Galaxy sifatida nomlanadi va har qanday talablarga javob beradi\"\n"+
 "      "))
        list.add(
            KompInfo(
                "Apple",
                "Apple iPhone'lari yuqori sifatli dizayn, kuchli ishlemchilar, yaxshi kamera sistemalari va samarali batareyalar bilan mashhur. Har bir yangi model, oldingi modellarga o'xshash ravishda batafsil qulayliklar bilan ta'minlanadi va foydalanuvchilar uchun yangi imkoniyatlarni o'z ichiga oladi.\"\n"+
        "   "))
        list.add(KompInfo("Oppo","Oppo telefonlarining yaxshi kamera sifati, tez batareya to'plash, yoritilgan ekranlar va ozgarcha dizayni, ularni foydalanuvchilar o'rtasida keng qo'llaniladigan qiladi. Har bir yangi model, oldingi modellarga o'xshash yaxshi xususiyatlarga ega bo'lsa-da, bu xususiyatlarning har biri mijozlar uchun eng maqbul bo'lishi mumkin.\"\n"))
        map[title[0]]?.addAll(list)
    }

}