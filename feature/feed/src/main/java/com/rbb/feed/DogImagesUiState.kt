package com.rbb.feed

import com.rbb.model.data.Image

sealed interface DogImagesUiState {
    data class Success(val dogImages: List<Image>) : DogImagesUiState
    data object Loading : DogImagesUiState
}
