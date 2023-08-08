package cl.gencina.perritosapp.data

import androidx.lifecycle.LiveData
import cl.gencina.perritosapp.data.remote.RazaAPI

/*class Repositorio(private val razaAPI: RazaAPI, private val razaDao: RazaDao) {

    fun obtenerRazas(): LiveData<List<RazaEntity>> = razaDao.getAll()

    suspend fun cargarRaza() {
        val response = razaAPI.getData()
        if(response.isSuccessful){
            val resp = response.body()
            resp?.let {razas ->
                val razasEntity = razas.map {
                    it.transformaraEntity()
                }
                razasDao.insertList(razasEntity)
            }
        }
    }

}*/
