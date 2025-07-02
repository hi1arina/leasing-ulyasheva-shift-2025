package com.example.leasing.cars_catalog.data.converter

import com.example.leasing.cars_catalog.data.model.CarsResponseModel
import com.example.leasing.cars_catalog.domain.entity.CarsResponse

object CarsResponseConverter {

    fun convert (response: CarsResponseModel) : CarsResponse =
        CarsResponse(
            success = response.success,
            reason = response.reason,
            data = response.data.map { CarConverter.convert(it) },
            meta = MetaConverter.convert(response.meta)
        )

}