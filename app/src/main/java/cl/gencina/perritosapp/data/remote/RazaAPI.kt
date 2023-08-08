package cl.gencina.perritosapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaAPI {
    @GET("breeds/list/all")
    suspend fun getAllData(): Response<RazaWrapper>

    @GET("breed/?raza/images")
    suspend fun getRazaImagesData(raza: String): Response<RazaImages>


}
