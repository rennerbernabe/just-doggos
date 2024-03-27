package com.rbb.model.data

data class ImageDetails(
    val id: String,
    val url: String,
    val breeds: List<Breed>,
    val width: Int,
    val height: Int,
) {
    val name
        get() = breeds.first().name

    val breedGroup
        get() = breeds.first().breedGroup

    val bredFor
        get() = breeds.first().bredFor

    val dogWeight
        get() = breeds.first().weight

    val dogHeight
        get() = breeds.first().height

    val lifeSpan
        get() = breeds.first().lifeSpan

    val temperament
        get() = breeds.first().temperament
}
