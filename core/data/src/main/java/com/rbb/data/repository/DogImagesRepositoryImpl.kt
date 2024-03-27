package com.rbb.data.repository

import com.rbb.model.data.Image
import com.rbb.model.data.ImageDetails
import com.rbb.network.model.asExternalModel
import com.rbb.network.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogImagesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : DogImagesRepository {

    override fun searchDogImages(): Flow<List<Image>> = flow {
        val data = apiService.searchDogImages()
        emit(data.asExternalModel())
    }

    override fun getImageDetails(id: String): Flow<ImageDetails> = flow {
        val data = apiService.getImageDetails(id)
        emit(data.asExternalModel())
    }
}
