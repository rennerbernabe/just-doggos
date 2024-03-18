package com.rbb.data.repository

import com.rbb.network.retrofit.RetrofitNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DogImagesModule {
    @Provides
    fun provideDogImagesRepository(
        retrofitNetworkApi: RetrofitNetworkApi
    ): DogImagesRepository {
        return DogImagesRepositoryImpl(retrofitNetworkApi)
    }
}
