package com.rbb.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun ImageDetailsScreen(
    modifier: Modifier = Modifier,
    viewmodel: ImageDetailsViewModel = hiltViewModel()
) {

    val imageDetailsUiState by viewmodel.imageDetailsUiState.collectAsStateWithLifecycle()
    when (imageDetailsUiState) {
        ImageDetailsUiState.Loading -> Unit
        is ImageDetailsUiState.Success -> {
            Column {
                val imageDetails = (imageDetailsUiState as ImageDetailsUiState.Success).imageDetails
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageDetails.url)
                        .build(),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "Dog image",
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .aspectRatio((imageDetails.width.toFloat() / imageDetails.height.toFloat()))
                )
                Text(text = "Name: ${imageDetails.name}", color = Color.White)

                if (imageDetails.breedGroup != null) {
                    Text(text = "Breed group: ${imageDetails.breedGroup}", color = Color.White)
                }

                if (imageDetails.bredFor != null) {
                    Text(text = "Bred for: ${imageDetails.bredFor}", color = Color.White)
                }

                Text(text = "Life span: ${imageDetails.lifeSpan}", color = Color.White)
                Text(text = "Weight: ${imageDetails.dogWeight} kg", color = Color.White)
                Text(text = "Height: ${imageDetails.dogHeight} cm", color = Color.White)

                if (imageDetails.temperament != null) {
                    Text(text = "Temperament: ${imageDetails.temperament}", color = Color.White)
                }
            }
        }
    }
}
