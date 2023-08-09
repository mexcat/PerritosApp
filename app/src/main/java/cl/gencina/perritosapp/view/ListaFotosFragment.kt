package cl.gencina.perritosapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gencina.perritosapp.databinding.ItemListaRazaBinding

class ListaFotosFragment : Fragment() {
    private var param1: String? = null
    lateinit var binding : ItemListaRazaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("nombreRaza")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemListaRazaBinding.inflate(layoutInflater,container,false)

        return binding.root
    }


}