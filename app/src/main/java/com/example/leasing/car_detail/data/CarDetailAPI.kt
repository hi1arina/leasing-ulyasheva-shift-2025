package com.example.leasing.car_detail.data

import com.example.leasing.car_detail.data.model.CarDetailResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CarDetailAPI {

    @GET("/api/cars/info/{carId}")
    suspend fun getCarDetail(
        @Path("carId") carId: String
    ): CarDetailResponseModel

}