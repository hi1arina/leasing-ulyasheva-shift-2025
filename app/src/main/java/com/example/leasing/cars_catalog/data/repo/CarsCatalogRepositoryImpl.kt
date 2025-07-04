package com.example.leasing.cars_catalog.data.repo

import com.example.leasing.cars_catalog.data.CarsCatalogAPI
import com.example.leasing.cars_catalog.data.converter.CarsResponseConverter
import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.CarsResponse
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Transmission
import com.example.leasing.cars_catalog.domain.repo.CarsCatalogRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarsCatalogRepositoryImpl() : CarsCatalogRepository {

    companion object {
        private const val BASE_URL = "https://shift-intensive.ru"
    }

    private val api: CarsCatalogAPI by lazy {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CarsCatalogAPI::class.java)
    }

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