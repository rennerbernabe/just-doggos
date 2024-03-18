package com.rbb.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val dogImagesState by viewModel.dogImagesState.collectAsStateWithLifecycle()

    Text("home")
    DogImageList(dogImagesState)
}

@Composable
fun DogImageList(
    dogImagesState: DogImagesUiState,
    modifier: Modifier = Modifier
) {
    when (dogImagesState) {
        DogImagesUiState.Loading -> Unit
        is DogImagesUiState.Success -> {
            LazyColumn(modifier) {
                items(
                    items = dogImagesState.dogImages,
                    key = { it.id },
                    contentType = { "dogImage" }) { dogImage ->
                    DogImageItem(dogImage.url)
                }
            }
        }
    }
}

@Composable
fun DogImageItem(url: String) {
    Text(text = url)
}

@Preview
@Composable
private fun DogImageItemPreview() {
    DogImageItem("")
}
