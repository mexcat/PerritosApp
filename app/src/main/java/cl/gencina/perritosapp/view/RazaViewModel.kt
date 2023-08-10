package cl.gencina.perritosapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.gencina.perritosapp.data.Repositorio
import cl.gencina.perritosapp.data.local.RazaDatabase
import cl.gencina.perritosapp.data.remote.RazaRetroFit
import kotlinx.coroutines.launch

class RazaViewModel(application: Application) : AndroidViewModel(application){
    private val repositorio:Repositorio
    init{
        val api = RazaRetroFit.getRetrofitRaza()
        val database = RazaDatabase.getDatabase(application).RazaDao()
        repositorio = Repositorio(api, database)
    }

    fun getData() = viewModelScope.launch {
        repositorio.cargarRazaData()
    }
    fun getFotos(raza:String) = viewModelScope.launch {
        repositorio.cargarFotos(raza)
    }

    fun razasLiveData() = repositorio.obtenerRazas()
    fun fotosRazasLiveData(raza:String) = repositorio.obtenerFotosPorRaza(raza)
}