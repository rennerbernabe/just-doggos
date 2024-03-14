package com.rbb.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rbb.model.data.DogImage

@Composable
fun HomeScreen() {

}

@Composable
fun DogImageList(dogImages: List<DogImage>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(items = dogImages) { dogImage ->

        }
    }
}

@Composable
fun DogItem() {
    //
}

// Add preview
