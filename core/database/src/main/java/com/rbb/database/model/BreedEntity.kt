package com.rbb.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rbb.model.data.Breed

@Entity(
    tableName = "breeds"
)

data class BreedEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(defaultValue = "")
    val description: String,
    @ColumnInfo(defaultValue = "")
    val countryCode: String,
    val weight: String,
    val height: String,
    @ColumnInfo(defaultValue = "")
    val bredFor: String,
    @ColumnInfo(defaultValue = "")
    val breedGroup: String,
    val lifeSpan: String,
    @ColumnInfo(defaultValue = "")
    val temperament: String,
    val origin: String?,
    val referenceImageId: String,
)

fun BreedEntity.asExternalModel() = Breed(
    id = id,
    name = name,
    description = description,
    countryCode = countryCode,
    weight = weight,
    height = height,
    bredFor = bredFor,
    breedGroup = breedGroup,
    lifeSpan = lifeSpan,
    temperament = temperament,
    origin = origin,
    referenceImageId = referenceImageId,
)
