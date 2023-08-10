package cl.gencina.perritosapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.gencina.perritosapp.databinding.FragmentListaFotosBinding
import java.util.Locale


class ListaFotosFragment : Fragment() {
    private var param1: String? = null
    lateinit var binding : FragmentListaFotosBinding
    private val viewModel: RazaViewModel by activityViewModels()

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
        binding = FragmentListaFotosBinding.inflate(layoutInflater,container,false)
        binding.tvNombreRaza.text = param1?.uppercase(Locale.ROOT)
        viewModel.getFotos(param1.toString())
        initAdapter()

        return binding.root
    }

    private fun initAdapter(){
        val adapter = AdapterListaRazaFotos()
        binding.rvListaFotos.adapter = adapter
        viewModel.fotosRazasLiveData(param1.toString()).observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}