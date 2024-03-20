package com.rbb.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkMeasurement(
    val imperial: String,
    val metric: String
)
