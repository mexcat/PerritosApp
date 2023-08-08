package cl.gencina.perritosapp.data

import androidx.lifecycle.LiveData
import cl.gencina.perritosapp.data.local.RazaDao
import cl.gencina.perritosapp.data.local.RazaEntity
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
        }
    }
    fun obtenerRazas(): LiveData<List<RazaEntity>> = razaDao.getAll()
}
