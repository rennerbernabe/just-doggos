package com.rbb.data.repository

import com.rbb.model.data.Breed
import com.rbb.model.data.DogImage
import kotlinx.coroutines.flow.Flow

interface DogImagesRepository {
    fun searchDogImages(): Flow<List<DogImage>>

    fun getDogBreeds(): Flow<List<Breed>>
}
