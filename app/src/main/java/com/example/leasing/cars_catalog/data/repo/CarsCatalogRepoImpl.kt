package com.example.leasing.cars_catalog.data.repo

import com.example.leasing.cars_catalog.data.CarsCatalogAPI
import com.example.leasing.cars_catalog.data.converter.CarsResponseConverter
import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.CarsResponse
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Transmission
import com.example.leasing.cars_catalog.domain.repo.CarsCatalogRepo

class CarsCatalogRepoImpl(
    private val api: CarsCatalogAPI
) : CarsCatalogRepo {

    override suspend fun getCarsCatalog(
        search: String?,
        minPrice: Int?,
        maxPrice: Int?,
        transmission: Transmission?,
        bodyType: BodyType?,
        brand: Brand?,
        color: Color?,
        page: Int,
        limit: Int
    ): CarsResponse {
        val carsCatalogResponse = api.getCarsCatalog(
            search = search,
            minPrice = minPrice,
            maxPrice = maxPrice,
            transmission = transmission?.toString(),
            bodyType = bodyType?.toString(),
            brand = brand?.toString(),
            color = color?.toString(),
            page = page,
            limit = limit
        )
        return CarsResponseConverter.convert(carsCatalogResponse)
    }
}