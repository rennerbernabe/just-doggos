package com.rbb.network

import com.rbb.network.model.NetworkDogImage

interface NetworkDataSource {
    suspend fun searchDogImages(): List<NetworkDogImage>
}
