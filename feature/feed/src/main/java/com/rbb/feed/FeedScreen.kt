package com.rbb.feed

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rbb.justdoggos.feature.feed.R
import com.rbb.model.data.DogImage

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = hiltViewModel()
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
            val cellConfiguration =
                if (LocalConfiguration.current.orientation == ORIENTATION_LANDSCAPE) {
                    StaggeredGridCells.Adaptive(minSize = 175.dp)
                } else StaggeredGridCells.Fixed(2)

            LazyVerticalStaggeredGrid(
                columns = cellConfiguration,
                contentPadding = PaddingValues(16.dp),
                verticalItemSpacing = 16.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(items = dogImagesState.dogImages) { dogImage ->
                    DogImageItem(dogImage, modifier)
                }
            }
        }
    }
}

@Composable
fun DogImageItem(dogImage: DogImage, modifier: Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(dogImage.url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.loader), // TODO add error
        contentDescription = "Dog image",
        contentScale = ContentScale.Fit,
//        error = painterResource(R.drawable.error), TODO add error
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Black)
    )
}

@Preview
@Composable
private fun DogImageItemPreview() {
//    DogImageItem("")
}
