package cl.gencina.perritosapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.perritosapp.data.local.RazaImageEntity
import cl.gencina.perritosapp.databinding.ItemListaFotosBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterListaRazaFotos: RecyclerView.Adapter<AdapterListaRazaFotos.ListaRazaFotoViewHolder>()  {
    lateinit var binding : ItemListaFotosBinding
    private val listaFotos = mutableListOf<RazaImageEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaRazaFotoViewHolder {
        binding = ItemListaFotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaRazaFotoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListaRazaFotoViewHolder, position: Int) {
        val foto = listaFotos[position]
        holder.bind(foto)
    }

    override fun getItemCount(): Int {
        return listaFotos.size
    }

    fun setData(listaFotos: List<RazaImageEntity>){
        this.listaFotos.clear()
        this.listaFotos.addAll(listaFotos)
        notifyDataSetChanged()
    }
    inner class ListaRazaFotoViewHolder(private val v : ItemListaFotosBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(razaImg: RazaImageEntity){
            v.imageDogsDetail.load(razaImg.urlImage){
                transformations(CircleCropTransformation())
            }
        }
    }
}