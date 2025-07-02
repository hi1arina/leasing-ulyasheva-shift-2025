package com.example.leasing.cars_catalog.domain.entity


data class CarsResponse(
    val success: Boolean,
    val reason: String,
    val data: List<Car>,
    val meta: Meta
)
