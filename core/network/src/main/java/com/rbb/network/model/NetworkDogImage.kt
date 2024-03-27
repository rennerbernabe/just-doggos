package com.rbb.network.model

import com.rbb.model.data.Image
import kotlinx.serialization.Serializable

@Serializable
data class NetworkDogImage(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
)

fun NetworkDogImage.asExternalModel() = Image(
    id = id,
    url = url,
    width = width,
    height = height,
)

fun List<NetworkDogImage>.asExternalModel() = map { it.asExternalModel() }
