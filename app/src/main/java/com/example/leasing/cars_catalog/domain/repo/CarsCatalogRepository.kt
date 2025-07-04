package com.example.leasing.cars_catalog.domain.repo

import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.CarsResponse
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Transmission

interface CarsCatalogRepository {
    suspend fun getCarsCatalog(
        search: String? = null,
        minPrice: Int? = null,
        maxPrice: Int? = null,
        transmission: Transmission? = null,
        bodyType: BodyType? = null,
        brand: Brand? = null,
        color: Color? = null,
        page: Int = 1,
        limit: Int = 10
    ): CarsResponse
}