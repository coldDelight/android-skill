package com.colddelight.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.colddelight.data.local.dao.CharacterDAO
import com.colddelight.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class,],
    version = 1
)
abstract class LocalDatabase: RoomDatabase() {
    abstract val characterDao : CharacterDAO
}