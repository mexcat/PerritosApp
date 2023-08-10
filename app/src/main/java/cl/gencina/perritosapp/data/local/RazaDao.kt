package cl.gencina.perritosapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : RazaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(item : List<RazaEntity>)

    @Query("SELECT * FROM tabla_raza ORDER BY nombreRaza ASC")
    fun getAll(): LiveData<List<RazaEntity>>

    @Query("Select * from tabla_raza where nombreRaza = :id")
    fun getRaza(id:String): LiveData<RazaEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : RazaImageEntity)


}