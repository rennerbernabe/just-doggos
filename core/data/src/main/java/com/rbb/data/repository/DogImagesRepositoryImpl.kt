package com.rbb.data.repository

import com.rbb.model.data.Breed
import com.rbb.model.data.DogImage
import com.rbb.network.model.asExternalModel
import com.rbb.network.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogImagesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : DogImagesRepository {

    override fun searchDogImages(): Flow<List<DogImage>> = flow {
        val data = apiService.searchDogImages()
        emit(data.asExternalModel())
    }

    override fun getDogBreeds(): Flow<List<Breed>> = flow {
        val data = apiService.getDogBreeds()
        emit(data.asExternalModel())
    }
}
