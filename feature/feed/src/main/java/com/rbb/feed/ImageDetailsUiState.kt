package com.rbb.feed

import com.rbb.model.data.ImageDetails

sealed interface ImageDetailsUiState {
    data class Success(val imageDetails: ImageDetails) : ImageDetailsUiState
    data object Loading : ImageDetailsUiState
}
