package com.rbb.data.di

import com.rbb.data.repository.BreedsRepository
import com.rbb.data.repository.BreedsRepositoryImpl
import com.rbb.data.repository.DogImagesRepository
import com.rbb.data.repository.DogImagesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsImagesRepository(
        dogImagesRepositoryImpl: DogImagesRepositoryImpl
    ): DogImagesRepository

    @Binds
    internal abstract  fun bindsBreedsRepository(
        breedsRepositoryImpl: BreedsRepositoryImpl
    ): BreedsRepository
}
