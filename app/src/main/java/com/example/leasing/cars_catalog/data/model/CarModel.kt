package com.example.leasing.cars_catalog.data.model

import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Steering
import com.example.leasing.cars_catalog.domain.entity.Transmission

data class CarModel(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaModel>,
    val transmission: Transmission,
    val price: Int,
    val location: String,
    val color: Color,
    val bodyType: BodyType,
    val steering: Steering
)
