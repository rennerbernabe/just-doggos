package com.rbb.feed

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.rbb.model.data.DogImage

@Composable
fun FeedScreen(
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
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    items = dogImagesState.dogImages,
                    key = { dogImage -> dogImage.id }
                ) { dogImage ->
                    DogImageItem(dogImage, modifier)
                }
            }
        }
    }
}

@Composable
fun DogImageItem(dogImage: DogImage, modifier: Modifier) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(dogImage.url)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.FillWidth,
        contentDescription = "Dog image",
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio((dogImage.width.toFloat() / dogImage.height.toFloat()))
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview
@Composable
private fun DogImageItemPreview() {
//    DogImageItem("")
}
