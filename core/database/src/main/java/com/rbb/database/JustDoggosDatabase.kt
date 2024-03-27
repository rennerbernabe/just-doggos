package com.rbb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rbb.database.dao.BreedDao
import com.rbb.database.model.BreedEntity

@Database(
    entities = [
        BreedEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
internal abstract class JustDoggosDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}
