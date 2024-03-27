package com.rbb.data.repository

import com.rbb.model.data.DogImage
import com.rbb.model.data.ImageDetails
import kotlinx.coroutines.flow.Flow

interface DogImagesRepository {
    fun searchDogImages(): Flow<List<DogImage>>

    fun getImageDetails(id: String): Flow<ImageDetails>
}
