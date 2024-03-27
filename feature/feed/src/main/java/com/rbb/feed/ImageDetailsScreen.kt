package com.rbb.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ImageDetailsScreen(id: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "Dog id: $id", color = Color.White)
    }
}
