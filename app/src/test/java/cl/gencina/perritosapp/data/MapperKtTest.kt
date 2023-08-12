package cl.gencina.perritosapp.data


import com.google.common.truth.Truth
import org.junit.Assert
import org.junit.Test

class MapperKtTest {


    @Test // test unitario
    fun toRazaEntity() {
        //DADO ESTE VALOR
        val id  = "idNombreRaza"
        //HAGO ESTO
        val result = id.toRazaEntity()
        //Y ESPERO ESTO

        //Assert.assertEquals(id, result.nombreRaza)
        //o
        Truth.assertThat(result.nombreRaza).isEqualTo(id)//

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
        Assert.assertEquals(id, result.razaNombre)
        Assert.assertEquals(url, result.urlImage)

    }
}