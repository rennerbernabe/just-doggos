package com.rbb.feed

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.graphics.drawable.Drawable
import androidx.compose.foundation.clickable
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
    viewModel: FeedViewModel = hiltViewModel(),
    onClick: () -> Unit
) {

    val imagesUiState by viewModel.imagesUiState.collectAsStateWithLifecycle()
    DogImageList(imagesUiState = imagesUiState, onClick = onClick)
}

@Composable
fun DogImageList(
    imagesUiState: DogImagesUiState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    when (imagesUiState) {
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
                    items = imagesUiState.dogImages,
                    key = { image -> image.id }
                ) { image ->
                    DogImageItem(
                        image = image,
                        modifier = modifier,
                        onClick = onClick
                    )
                }
            }
        }
    }
}

@Composable
fun DogImageItem(
    image: DogImage,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image.url)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.FillWidth,
        contentDescription = "Dog image",
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio((image.width.toFloat() / image.height.toFloat()))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }

    )
}

@Preview
@Composable
private fun DogImageItemPreview() {
//    DogImageItem("")
}
