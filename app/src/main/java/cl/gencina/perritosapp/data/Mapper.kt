package cl.gencina.perritosapp.data

import cl.gencina.perritosapp.data.local.RazaEntity
import cl.gencina.perritosapp.data.local.RazaImageEntity

fun String.toEntity(id:String):RazaImageEntity = RazaImageEntity(id,this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)
