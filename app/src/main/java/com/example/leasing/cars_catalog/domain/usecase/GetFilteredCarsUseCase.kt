package com.example.leasing.cars_catalog.domain.usecase

import com.example.leasing.cars_catalog.domain.entity.Car

class GetFilteredCarsUseCase() {
    fun invoke(query: String, cars: List<Car>): List<Car> {
        if (query.isBlank()) return cars
        return cars.filter { it.name.contains(query, ignoreCase = true) }
    }
}