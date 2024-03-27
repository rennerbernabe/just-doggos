package com.rbb.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbb.data.repository.DogImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    dogImagesRepository: DogImagesRepository,
) : ViewModel() {

    val imagesUiState: StateFlow<DogImagesUiState> =
        dogImagesRepository.searchDogImages()
            .map(DogImagesUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = DogImagesUiState.Loading,
            )
}
