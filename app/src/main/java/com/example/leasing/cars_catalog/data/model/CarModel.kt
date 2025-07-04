package com.example.leasing.cars_catalog.data.model

data class CarModel(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaModel>,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)
