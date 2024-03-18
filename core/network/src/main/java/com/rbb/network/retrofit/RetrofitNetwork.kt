package com.rbb.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rbb.network.NetworkDataSource
import com.rbb.network.model.NetworkDogImage
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

private const val BASE_URL = "https://api.thedogapi.com/v1"

interface RetrofitNetworkApi {
    @GET(value = "images/search")
    suspend fun searchDogImages(): List<NetworkDogImage>
}

// Applied to functions with list parameters
@Serializable
data class NetworkResponse<T>(
    val data: T,
)

class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okHttpClient: dagger.Lazy<Call.Factory>,
): NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        // We use callFactory lambda here with dagger.Lazy<Call.Factory>
        // to prevent initializing OkHttp on the main thread.
        .callFactory { okHttpClient.get().newCall(it) }
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun searchDogImages(): List<NetworkDogImage> =
        networkApi.searchDogImages()
}
