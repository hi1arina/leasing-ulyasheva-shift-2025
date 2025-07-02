package com.example.leasing.cars_catalog.domain.entity

data class Car(
    val id: String,
    val name: String,
    val brand: Brand,
    val media: List<Media>,
    val transmission: Transmission,
    val price: Int,
    val location: String,
    val color: Color,
    val bodyType: BodyType,
    val steering: Steering
)
