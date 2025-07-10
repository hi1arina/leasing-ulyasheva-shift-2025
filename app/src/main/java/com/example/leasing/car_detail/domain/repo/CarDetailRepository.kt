package com.example.leasing.car_detail.domain.repo

import com.example.leasing.car_detail.domain.entity.CarDetail

interface CarDetailRepository {
    suspend fun getCarDetail(carId: String): CarDetail
}