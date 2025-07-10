package com.example.leasing.car_detail.presentation

import com.example.leasing.car_detail.domain.entity.CarDetail

sealed class CarDetailState {
    object Initial : CarDetailState()
    object Loading : CarDetailState()
    data class Content(val car: CarDetail) : CarDetailState()
}