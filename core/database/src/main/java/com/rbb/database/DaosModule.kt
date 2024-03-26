package com.rbb.database

import com.rbb.database.dao.BreedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesBreedDao(
        database: JustDoggosDatabase,
    ): BreedDao = database.breedDao()
}
