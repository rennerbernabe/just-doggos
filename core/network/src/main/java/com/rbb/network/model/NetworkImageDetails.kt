package com.rbb.network.model

import com.rbb.model.data.ImageDetails
import kotlinx.serialization.Serializable

@Serializable
data class NetworkImageDetails(
    val id: String,
    val url: String,
    val breeds: List<NetworkBreed>,
    val width: String,
    val height: String,
)

fun NetworkImageDetails.asExternalModel() = ImageDetails(
    id = id,
    url = url,
    breeds = breeds.map(NetworkBreed::asExternalModel),
    width = width,
    height = height,
)
