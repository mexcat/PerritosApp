package cl.gencina.perritosapp.data

import org.junit.Assert.*

import org.junit.Test

class MapperKtTest {


    @Test // test unitario
    fun toRazaEntity() {
        //DADO ESTE VALOR
        val id  = "idNombreRaza"
        //HAGO ESTO
        val result = id.toRazaEntity()
        //Y ESPERO ESTO
        assertEquals(id, result.nombreRaza)

    }

    @Test // test unitario
    fun toEntity() {
        //DADO ESTE VALOR
        val url  = "url"
        val id = "idNombreRaza"
        //HAGO ESTO

        val result = url.toEntity(id)
//        "url".toEntity("idNombreRaza")
        //Y ESPERO ESTO
        assertEquals(id, result.razaNombre)
        assertEquals(url, result.urlImage)

    }
}