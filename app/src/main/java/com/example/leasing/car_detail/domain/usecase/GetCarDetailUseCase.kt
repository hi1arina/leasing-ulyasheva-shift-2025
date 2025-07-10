package com.example.leasing.car_detail.domain.usecase

import com.example.leasing.car_detail.domain.entity.CarDetail
import com.example.leasing.car_detail.domain.repo.CarDetailRepository

class GetCarDetailUseCase(
    private val repository: CarDetailRepository
) {
    suspend operator fun invoke(carId: String): CarDetail {
        return repository.getCarDetail(carId)
    }
}