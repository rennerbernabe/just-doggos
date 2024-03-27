package com.rbb.network.retrofit

import com.rbb.network.model.NetworkBreed
import com.rbb.network.model.NetworkDogImage
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    suspend fun searchDogImages(
        @Query("limit") limit: Int = 10,
        @Query("has_breeds") hasBreeds: Int = 1
    ): List<NetworkDogImage>

    @GET("breeds")
    suspend fun getBreeds(): List<NetworkBreed>
}
