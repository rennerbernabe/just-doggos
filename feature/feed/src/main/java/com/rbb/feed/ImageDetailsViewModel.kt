package com.rbb.feed

import androidx.lifecycle.SavedStateHandle
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
class ImageDetailsViewModel @Inject constructor(
    imagesRepository: DogImagesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val id = savedStateHandle.get<String>("id") ?: ""
    val imageDetailsUiState: StateFlow<ImageDetailsUiState> =
        imagesRepository.getImageDetails(id)
            .map(ImageDetailsUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ImageDetailsUiState.Loading,
            )
}
