package com.rbb.data.repository

import com.rbb.model.data.Image
import com.rbb.model.data.ImageDetails
import kotlinx.coroutines.flow.Flow

interface DogImagesRepository {
    fun searchDogImages(): Flow<List<Image>>

    fun getImageDetails(id: String): Flow<ImageDetails>
}
