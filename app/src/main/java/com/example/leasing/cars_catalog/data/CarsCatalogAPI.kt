package com.example.leasing.cars_catalog.data

import com.example.leasing.cars_catalog.data.model.CarsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsCatalogAPI {

    companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_LIMIT = 10
    }

    @GET("/api/cars/info")
    suspend fun getCarsCatalog(
        @Query("search") search: String? = null,
        @Query("minPrice") minPrice: Int? = null,
        @Query("maxPrice") maxPrice: Int? = null,
        @Query("transmission") transmission: String? = null,
        @Query("bodyType") bodyType: String? = null,
        @Query("brand") brand: String? = null,
        @Query("color") color: String? = null,
        @Query("page") page: Int = DEFAULT_PAGE,
        @Query("limit") limit: Int = DEFAULT_LIMIT
    ): CarsResponseModel

}