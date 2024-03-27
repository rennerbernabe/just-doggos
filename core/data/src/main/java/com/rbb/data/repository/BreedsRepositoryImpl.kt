package com.rbb.data.repository

import com.rbb.database.dao.BreedDao
import com.rbb.database.model.BreedEntity
import com.rbb.database.model.asExternalModel
import com.rbb.model.data.Breed
import com.rbb.network.model.NetworkBreed
import com.rbb.network.model.asEntity
import com.rbb.network.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BreedsRepositoryImpl @Inject constructor(
    private val breedDao: BreedDao,
    private val apiService: ApiService
) : BreedsRepository {

    override suspend fun getBreeds(): Flow<List<Breed>> {
        // Read local db
        val breeds = breedDao.getBreedEntities()
            .map { it.map(BreedEntity::asExternalModel) }
        val data = breeds.firstOrNull()
        return if (data != null) {
            breeds
        } else {
            // Get remote data
            flow {
                val networkBreeds = apiService.getBreeds()
                val breedEntities = networkBreeds.map(NetworkBreed::asEntity)
                breedDao.upsertBreeds(breedEntities = breedEntities)
            }
        }
    }
}
