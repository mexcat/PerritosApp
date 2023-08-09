package cl.gencina.perritosapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.gencina.perritosapp.databinding.FragmentListaRazaBinding

class ListaRazaFragment : Fragment() {

    private lateinit var binding : FragmentListaRazaBinding
    private val viewModel: RazaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaRazaBinding.inflate(layoutInflater, container, false)
        viewModel.getData()
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        val adapter = AdapterListaRaza()
        binding.rvListaRaza.adapter = adapter
        viewModel.razasLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}