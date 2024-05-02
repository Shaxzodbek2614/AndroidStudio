package com.example.todo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.databinding.ActivityMain2Binding
import com.example.todo.utils.MyData

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val childPosition = intent.getIntExtra("key1", 0)
        val item = intent.getIntExtra("key2", 0)
        val groupPosition = intent.getIntExtra("key3",0)
        binding.tvName.text = MyData.title[groupPosition][childPosition].toString()
        binding.tvInfo.text =

//        if (groupPosition == 0 && childPosition == 0) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Xiaomi xususiy kompaniya bo'lib, u smartfonlar, Android operatsion tizimi va boshqa maishiy elektronikalarni loyihalash, ishlab chiqish va sotish bilan shug'ullanadi. Xiaomi shuningdek, fitnes-trekerlar, televizorlar, havo tozalagichlar va planshetlar ishlab chiqaradi. Uning Android telefonlari va planshetlari uchun jild mavjud - MIUI."
//        } else if (groupPosition == 0 && childPosition == 1) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Samsung telefonlarining ko'p yonalishi bor va har yili yangi model chiqadi. Bu telefonlar ommabop bo'lgan Galaxy sifatida nomlanadi va har qanday talablarga javob beradi"
//        } else if (groupPosition == 0 && childPosition == 2) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Apple iPhone'lari yuqori sifatli dizayn, kuchli ishlemchilar, yaxshi kamera sistemalari va samarali batareyalar bilan mashhur. Har bir yangi model, oldingi modellarga o'xshash ravishda batafsil qulayliklar bilan ta'minlanadi va foydalanuvchilar uchun yangi imkoniyatlarni o'z ichiga oladi."
//        } else if (groupPosition == 0 && childPosition == 3) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Oppo telefonlarining yaxshi kamera sifati, tez batareya to'plash, yoritilgan ekranlar va ozgarcha dizayni, ularni foydalanuvchilar o'rtasida keng qo'llaniladigan qiladi. Har bir yangi model, oldingi modellarga o'xshash yaxshi xususiyatlarga ega bo'lsa-da, bu xususiyatlarning har biri mijozlar uchun eng maqbul bo'lishi mumkin."
//        }else if (groupPosition == 1 && childPosition == 0) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Dell kompyuterlari, ta'lim, korxonalar, shaxsiy ishlab chiqarish va o'yinlar uchun moslashtirilgan ko'plab variantlarda kelajakning muhim kompyuter brendlaridan biri hisoblanadi. Har bir seriyada, xususiyatlar va qulayliklar bir qancha ko'p joylashadi, shuning uchun xaridorlar o'zlariga moslashtirilgan eng qulay variantni tanlashlari mumkin."
//        }else if (groupPosition == 1 && childPosition == 1) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Acer kompyuterlari, foydalanuvchilar uchun muhim vaqtda yaxshi xususiyatlarga ega bo'lishi, lekin ularning narxi bilan tanqidiy bo'lishi mumkin. Har bir seriyada, xususiyatlar va qulayliklar bir qancha ko'p joylashadi, shuning uchun xaridorlar o'zlariga moslashtirilgan eng qulay variantni tanlashlari mumkin. "
//        }else if (groupPosition == 1 && childPosition == 2) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "Mac OS (Macintosh operatsion tizimi) - Apple tomonidan ishlab chiqarilgan operatsion tizimlar guruhi shaxsiy kompyuterlar Macintosh.Tizim birinchilardan bo'lib foydalanuvchiga tushunish qiyin bo'lgan buyruq qatori o'rniga intuitiv grafik interfeysni taqdim etdi.Birinchi marta Mac OS birinchi Macintosh kompyuter bilan 1984 yilda taqdim etilgan. Mac OS atamasi faqat 90-yillarning o'rtalarida qo'llanila boshlandi."
//        }else if (groupPosition == 1 && childPosition == 3) {
//            binding.tvName.text = MyData.map[MyData.title[groupPosition]]?.get(childPosition)
//            binding.tvInfo.text =
//                "HP kompyuterlari yuqori sifat, ishonchli xususiyatlar va yaxshi dizayn bilan mashhurdir. Har bir seriyada, xususiyatlar va qulayliklar bir qancha ko'p joylashadi, shuning uchun xaridorlar o'zlariga moslashtirilgan eng qulay variantni tanlashlari mumkin."
//        }
    }
}
