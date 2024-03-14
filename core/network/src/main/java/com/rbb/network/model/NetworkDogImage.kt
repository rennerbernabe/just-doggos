package com.rbb.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkDogImage(
    val id: String,
    val url: String,
    val width: String,
    val height: String
)
