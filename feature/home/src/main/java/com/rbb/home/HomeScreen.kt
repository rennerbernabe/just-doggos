package com.rbb.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val dogImagesState by viewModel.dogImagesState.collectAsStateWithLifecycle()

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
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
//        placeholder = painterResource(R.drawable.placeholder), TODO add placeholder
        contentDescription = "Dog image",
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun DogImageItemPreview() {
    DogImageItem("")
}
