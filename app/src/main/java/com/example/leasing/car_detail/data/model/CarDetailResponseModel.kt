package com.example.leasing.car_detail.data.model

data class CarDetailResponseModel(
    val success: Boolean,
    val reason: String?,
    val data: CarDetailModel
)