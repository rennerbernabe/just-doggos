package com.rbb.network.model

import com.rbb.model.data.Breed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkBreed(
    val id: Int,
    val name: String,
    val description: String?,
    @SerialName("country_code")
    val countryCode: String?,
    val weight: NetworkMeasurement,
    val height: NetworkMeasurement,
    @SerialName("bred_for")
    val bredFor: String?,
    @SerialName("breed_group")
    val breedGroup: String?,
    @SerialName("life_span")
    val lifeSpan: String,
    val temperament: String?,
    val origin: String?,
    @SerialName("reference_image_id")
    val referenceImageId: String,
)

fun NetworkBreed.asExternalModel() = Breed(
    id = id,
    name = name,
    description = description,
    countryCode = countryCode,
    weight = weight.metric,
    height = height.metric,
    bredFor = bredFor,
    breedGroup = breedGroup,
    lifeSpan = lifeSpan,
    temperament = temperament,
    origin = origin,
    referenceImageId = referenceImageId,
)

fun List<NetworkBreed>.asExternalModel() = map { it.asExternalModel() }
