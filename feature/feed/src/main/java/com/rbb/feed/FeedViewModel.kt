package com.rbb.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbb.data.repository.DogImagesRepository
import com.rbb.model.data.DogImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val dogImagesRepository: DogImagesRepository
) : ViewModel() {

    private val _data = MutableSharedFlow<List<DogImage>>()
    val data = _data.asSharedFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    val dogImagesState: StateFlow<DogImagesUiState> =
        dogImagesRepository.searchDogImages()
            .map(DogImagesUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = DogImagesUiState.Loading,
            )

    // TODO move to dog breeds repository
    val breedsState: StateFlow<BreedsUiState> =
        dogImagesRepository.getDogBreeds()
            .map(BreedsUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = BreedsUiState.Loading,
            )
}
