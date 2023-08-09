package cl.gencina.perritosapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.perritosapp.R
import cl.gencina.perritosapp.data.local.RazaEntity
import cl.gencina.perritosapp.databinding.ItemListaRazaBinding

class AdapterListaRaza:RecyclerView.Adapter<AdapterListaRaza.ListaRazaViewHolder>() {
    lateinit var binding : ItemListaRazaBinding
    private val listaRazas = mutableListOf<RazaEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaRazaViewHolder {
        binding = ItemListaRazaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaRazaViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListaRazaViewHolder, position: Int) {
        val raza = listaRazas[position]
        holder.bind(raza)
    }
    override fun getItemCount(): Int {
        return listaRazas.size
    }
    fun setData(listaRazas : List<RazaEntity>){
        this.listaRazas.clear()
        this.listaRazas.addAll(listaRazas)
        notifyDataSetChanged()
    }

    class ListaRazaViewHolder(private val v : ItemListaRazaBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(raza:RazaEntity){
            v.tvListaRaza.text = raza.nombreRaza
            v.cvListaRaza.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("nombreRaza", raza.nombreRaza)
                Navigation.findNavController(v.root).navigate(R.id.action_listaRazaFragment_to_listaFotosFragment, bundle)
            }
        }

    }
}