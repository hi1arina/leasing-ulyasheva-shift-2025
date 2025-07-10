package com.example.leasing.car_detail.data.converter

import com.example.leasing.car_detail.data.model.CarDetailModel
import com.example.leasing.car_detail.domain.entity.CarDetail
import com.example.leasing.cars_catalog.data.converter.CarConverter
import com.example.leasing.cars_catalog.data.converter.MediaConverter
import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Steering
import com.example.leasing.cars_catalog.domain.entity.Transmission

object CarDetailConverter {

    //тут тоже используются классы из cars_catalog
    fun convert(model: CarDetailModel): CarDetail = CarDetail(
        id = model.id,
        name = model.name,
        brand = mapBrand(model.brand),
        media = model.media.map { MediaConverter.convert(it) },
        transmission = mapTransmission(model.transmission),
        price = model.price,
        location = model.location,
        color = mapColor(model.color),
        bodyType = mapBodyType(model.bodyType),
        steering = mapSteering(model.steering),
        rents = model.rents.map { RentConverter.convert(it) })

    private fun mapBrand(brand: String): Brand = CarConverter.mapBrand(brand)
    private fun mapTransmission(transmission: String): Transmission =
        CarConverter.mapTransmission(transmission)

    private fun mapBodyType(bodyType: String): BodyType = CarConverter.mapBodyType(bodyType)
    private fun mapSteering(steering: String): Steering = CarConverter.mapSteering(steering)
    private fun mapColor(color: String): Color = CarConverter.mapColor(color)
}