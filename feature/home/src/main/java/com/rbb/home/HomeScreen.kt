package com.rbb.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rbb.model.data.Breed
import com.rbb.model.data.DogImage

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text("home")
    DogImageList(
        listOf(
            DogImage(
                id = "", url = "", "", "", "",
                Breed("", "", "", "", "", "")
            ),
            DogImage(
                id = "", url = "", "", "", "",
                Breed("", "", "", "", "", "")
            ),
            DogImage(
                id = "", url = "", "", "", "",
                Breed("", "", "", "", "", "")
            )
        )
    )
}

@Composable
fun DogImageList(dogImages: List<DogImage>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(items = dogImages) { dogImage ->
            DogImageItem(dogImage.url)
        }
    }
}

@Composable
fun DogImageItem(url: String) {
    //
}

@Preview
@Composable
private fun DogImageItemPreview() {
    DogImageItem("")
}
