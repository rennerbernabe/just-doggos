package com.rbb.feed

import com.rbb.model.data.Breed

sealed interface BreedsUiState {
    data class Success(val breeds: List<Breed>) : BreedsUiState
    data object Loading : BreedsUiState
}
