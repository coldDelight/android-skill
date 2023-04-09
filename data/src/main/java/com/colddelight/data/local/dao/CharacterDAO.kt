package com.colddelight.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.colddelight.data.local.entity.CharacterEntity

@Dao
interface CharacterDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetCharacter(character : CharacterEntity)

    @Query("SELECT * FROM character")
    suspend fun getCharacter():List<CharacterEntity>

}