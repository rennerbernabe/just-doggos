package com.rbb.data.repository

import com.rbb.model.data.Breed
import kotlinx.coroutines.flow.Flow

interface BreedsRepository {
    suspend fun getBreeds(): Flow<List<Breed>>
}
