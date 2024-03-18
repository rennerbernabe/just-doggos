package com.rbb.network.retrofit

import com.rbb.network.model.NetworkDogImage
import retrofit2.http.GET

interface ApiService {
    @GET("images/search")
    suspend fun searchDogImages(): List<NetworkDogImage>
}
