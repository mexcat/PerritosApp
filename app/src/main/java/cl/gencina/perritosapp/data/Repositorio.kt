package cl.gencina.perritosapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.gencina.perritosapp.data.local.RazaDao
import cl.gencina.perritosapp.data.local.RazaEntity
import cl.gencina.perritosapp.data.local.RazaImageEntity
import cl.gencina.perritosapp.data.remote.RazaAPI

class Repositorio(private val razaAPI: RazaAPI, private val razaDao: RazaDao) {

    suspend fun cargarRazaData() {
        val response = razaAPI.getAllData()
        if(response.isSuccessful){
            val keys = response.body()?.message?.keys
            keys?.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insert(razaEntity)
            }
        }else{
            Log.e("repositorio", response.body().toString())
        }
    }

    suspend fun cargarFotos(raza:String): MutableList<String> {
        val response = razaAPI.getRazaImagesData(raza)
        val lista = mutableListOf<String>()
        lista.clear()
        if(response.isSuccessful){
            val message = response.body()?.message
            message?.forEach {
                val perroDetalle = RazaImageEntity(raza, it)
                razaDao.insert(perroDetalle)
            }
        }else{
            Log.e("repositorio", response.body().toString())
        }
        return lista
    }

    fun obtenerRazas(): LiveData<List<RazaEntity>> = razaDao.getAll()
    fun obtenerFotosPorRaza(id:String): LiveData<List<RazaImageEntity>> = razaDao.getImagenRaza(id)
}
