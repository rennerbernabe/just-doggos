package com.rbb.model.data

data class ImageDetails(
    val id: String,
    val url: String,
    val breeds: List<Breed>,
    val width: String,
    val height: String,
)
