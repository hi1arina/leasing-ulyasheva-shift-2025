package com.example.leasing.car_detail.data.converter

import com.example.leasing.car_detail.data.model.RentModel
import com.example.leasing.car_detail.domain.entity.Rent

object RentConverter {
    fun convert(model: RentModel): Rent = Rent(
        startDate = model.startDate, endDate = model.endDate
    )
}