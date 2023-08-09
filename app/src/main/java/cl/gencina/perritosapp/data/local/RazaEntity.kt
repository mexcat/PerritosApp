package cl.gencina.perritosapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_raza")
data class RazaEntity(
    @PrimaryKey val nombreRaza: String
)