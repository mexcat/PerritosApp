package cl.gencina.perritosapp.data.local

import androidx.room.Entity

@Entity(tableName = "detalle_raza_entity", primaryKeys = ["razaNombre", "urlImage"])
data class RazaImageEntity (
    val razaNombre:String,
    val urlImage: String

)