package com.rbb.data.repository

import com.rbb.model.data.DogImage
import com.rbb.network.model.asExternalModel
import com.rbb.network.retrofit.RetrofitNetworkApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogImagesRepositoryImpl @Inject constructor(
    private val retrofitNetworkApi: RetrofitNetworkApi
) : DogImagesRepository {

    override fun searchDogImages(): Flow<List<DogImage>> = flow {
        val data = retrofitNetworkApi.searchDogImages()
        emit(data.asExternalModel())
    }
}
