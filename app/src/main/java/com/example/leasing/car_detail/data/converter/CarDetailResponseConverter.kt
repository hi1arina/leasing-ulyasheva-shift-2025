package com.example.leasing.car_detail.data.converter

import com.example.leasing.car_detail.data.model.CarDetailResponseModel
import com.example.leasing.car_detail.domain.entity.CarDetailResponse

object CarDetailResponseConverter {
    fun convert(response: CarDetailResponseModel): CarDetailResponse = CarDetailResponse(
        success = response.success,
        reason = response.reason,
        data = CarDetailConverter.convert(response.data)
    )
}