package com.rbb.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rbb.database.model.BreedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {
    @Query(
        value = """
        SELECT * FROM breeds
        WHERE id = :breedId
        """
    )
    fun getBreedEntity(breedId: String): Flow<BreedEntity>

    @Query(value = "SELECT * FROM breeds")
    fun getBreedEntities(): Flow<List<BreedEntity>>

    @Query(
        value = """
        SELECT * FROM breeds
        WHERE id IN (:ids)
    """,
    )
    fun getBreedEntities(ids: Set<String>): Flow<List<BreedEntity>>

    @Upsert
    suspend fun upsertBreeds(entities: List<BreedEntity>)
}
