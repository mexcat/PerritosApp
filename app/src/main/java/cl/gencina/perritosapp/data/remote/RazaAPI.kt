package cl.gencina.perritosapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RazaAPI {
    @GET("breeds/list/all")
    suspend fun getAllData(): Response<RazaWrapper>

    @GET("breed/{raza}/images")
    suspend fun getRazaImagesData(@Path("raza") raza: String): Response<RazaImages>


}
