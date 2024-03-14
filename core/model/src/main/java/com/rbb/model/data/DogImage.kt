package com.rbb.model.data

data class DogImage(
    val id: String,
    val url: String,
    val width: String,
    val height: String,
    val mimeType: String,
    val breeds: Breed,
)
