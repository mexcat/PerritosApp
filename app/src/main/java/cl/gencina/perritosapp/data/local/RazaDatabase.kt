package cl.gencina.perritosapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaEntity::class, RazaImageEntity::class], version = 1)
abstract class RazaDatabase : RoomDatabase() {
    abstract fun RazaDao(): RazaDao

    companion object{
        @Volatile
        private var INSTANCE: RazaDatabase? = null

        fun getDatabase(context: Context):RazaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RazaDatabase::class.java,
                    "terrenos_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}