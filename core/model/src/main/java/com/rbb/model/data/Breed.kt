package com.rbb.model.data

data class Breed(
    val id: Int,
    val name: String,
    val description: String?,
    val countryCode: String?,
    val weight: String,
    val height: String,
    val bredFor: String?,
    val breedGroup: String?,
    val lifeSpan: String,
    val temperament: String?,
    val origin: String?,
    val referenceImageId: String,
)
