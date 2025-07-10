package com.example.leasing.car_detail.data.repo

import com.example.leasing.car_detail.data.CarDetailAPI
import com.example.leasing.car_detail.data.converter.CarDetailConverter
import com.example.leasing.car_detail.domain.entity.CarDetail
import com.example.leasing.car_detail.domain.repo.CarDetailRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarDetailRepositoryImpl : CarDetailRepository {

    companion object {
        private const val BASE_URL = "https://shift-intensive.ru"
    }

    private val api: CarDetailAPI by lazy {
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

        retrofit.create(CarDetailAPI::class.java)
    }

    override suspend fun getCarDetail(carId: String): CarDetail {
        val response = api.getCarDetail(carId)
        return CarDetailConverter.convert(response.data)
    }

}