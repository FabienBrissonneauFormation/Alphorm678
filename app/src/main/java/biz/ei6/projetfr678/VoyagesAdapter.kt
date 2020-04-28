package biz.ei6.projetfr678

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VH( itemView: View) : RecyclerView.ViewHolder(itemView) {

    var  texte : TextView

    init {
        texte = itemView.findViewById(R.id.item_list_voyage_tv)
    }
}

class VoyagesAdapter(val context : Context, val data : ArrayList<Voyage>)  : RecyclerView.Adapter<VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.voyages_list_item,parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.texte.text = data[position].toString()
    }


}