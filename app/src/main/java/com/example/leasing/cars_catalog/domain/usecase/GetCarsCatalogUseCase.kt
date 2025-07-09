package com.example.leasing.cars_catalog.domain.usecase

import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.CarsResponse
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Transmission
import com.example.leasing.cars_catalog.domain.repo.CarsCatalogRepository

class GetCarsCatalogUseCase(
    private val repository: CarsCatalogRepository
) {
    suspend fun invoke(
        search: String?,
        minPrice: Int?,
        maxPrice: Int?,
        transmission: Transmission?,
        bodyType: BodyType?,
        brand: Brand?,
        color: Color?,
        page: Int,
        limit: Int
    ): CarsResponse =
        repository.getCarsCatalog(
            search = search,
            minPrice = minPrice,
            maxPrice = maxPrice,
            transmission = transmission,
            bodyType = bodyType,
            brand = brand,
            color = color,
            page = page,
            limit = limit
        )
}