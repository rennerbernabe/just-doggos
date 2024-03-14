package com.rbb.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rbb.network.NetworkDataSource
import com.rbb.network.model.NetworkDogImage
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://api.thedogapi.com/v1"
interface RetrofitNetworkApi {
    @GET(value = "images/search")
    suspend fun searchDogImages(): NetworkResponse<List<NetworkDogImage>>
}

@Serializable
data class NetworkResponse<T>(
    val data: T,
)

class RetrofitNetwork : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun searchDogImages(): List<NetworkDogImage> =
        networkApi.searchDogImages().data
}
