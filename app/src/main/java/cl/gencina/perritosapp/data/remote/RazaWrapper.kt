package cl.gencina.perritosapp.data.remote

data class RazaWrapper (
    val status: String,
    val message: Map<String, List<String>>
)