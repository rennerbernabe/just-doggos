package com.rbb.home

import com.rbb.model.data.DogImage

sealed interface DogImagesUiState {
    data class Success(val dogImages: List<DogImage>) : DogImagesUiState
    data object Loading : DogImagesUiState
}
