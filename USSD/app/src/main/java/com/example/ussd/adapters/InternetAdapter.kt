import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.databinding.InternetItemBinding
import com.example.ussd.models.Internet

private const val TAG = "InternetAdapter"
class InternetAdapter(var context: Context?, var list:ArrayList<Internet>): RecyclerView.Adapter<InternetAdapter.Vh>() {
    inner class Vh(var internetItemBinding: InternetItemBinding ):RecyclerView.ViewHolder(internetItemBinding.root){
        fun onBind(movie: Internet, position: Int){
            internetItemBinding.name.text = movie.name
            internetItemBinding.narxi.text = movie.narxi
            internetItemBinding.kodi.text = movie.kodi
            internetItemBinding.muddati.text = movie.muddati
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(InternetItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}