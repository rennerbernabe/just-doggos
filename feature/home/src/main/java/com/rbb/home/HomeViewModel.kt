package com.rbb.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbb.data.repository.BreedsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val breedsRepository: BreedsRepository,
) : ViewModel() {

    init {
        viewModelScope.launch {
            breedsRepository.getBreeds().collect()
        }
    }
}
