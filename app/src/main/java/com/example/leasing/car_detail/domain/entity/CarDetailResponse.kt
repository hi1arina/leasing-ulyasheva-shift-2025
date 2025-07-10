package com.example.leasing.car_detail.domain.entity

data class CarDetailResponse(
    val success: Boolean,
    val reason: String?,
    val data: CarDetail
)
