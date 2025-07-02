package com.example.leasing.cars_catalog.data.model

data class CarsResponseModel(
    val success: Boolean,
    val reason: String,
    val data: List<CarModel>,
    val meta: MetaModel
)
