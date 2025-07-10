package com.example.leasing.cars_catalog.data.converter

import com.example.leasing.cars_catalog.data.model.CarModel
import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.Car
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Steering
import com.example.leasing.cars_catalog.domain.entity.Transmission

object CarConverter {

    fun mapBrand(brand: String): Brand = when (brand.trim()) {
        "Haval" -> Brand.HAVAL
        "Hyundai" -> Brand.HYUNDAI
        "Volkswagen" -> Brand.VOLKSWAGEN
        "Kia" -> Brand.KIA
        "Geely" -> Brand.GEELY
        "Mercedes" -> Brand.MERCEDES
        "Garden car" -> Brand.GARDENCAR
        "Grocery cart" -> Brand.GROCERYCART
        "Haier" -> Brand.HAIER
        else -> Brand.INVALID
    }

    fun mapTransmission(transmission: String): Transmission = when (transmission.trim()) {
        "automatic" -> Transmission.AUTOMATIC
        else -> Transmission.MANUAL
    }

    fun mapBodyType(bodyType: String): BodyType = when (bodyType.trim()) {
        "sedan" -> BodyType.SEDAN
        "suv" -> BodyType.SUV
        "coupe" -> BodyType.COUPE
        "hatchback" -> BodyType.HATCHBACK
        else -> BodyType.CABRIOLET
    }

    fun mapSteering(steering: String): Steering = when (steering.trim()) {
        "left" -> Steering.LEFT
        else -> Steering.RIGHT
    }

    fun mapColor(color: String): Color = when (color.trim()) {
        "black" -> Color.BLACK
        "white" -> Color.WHITE
        "red" -> Color.RED
        "silver" -> Color.SILVER
        "blue" -> Color.BLUE
        "grey" -> Color.GREY
        else -> Color.ORANGE
    }

    fun convert(car: CarModel): Car =
        Car(
            id = car.id,
            name = car.name,
            brand = mapBrand(car.brand),
            media = car.media.map { MediaConverter.convert(it) },
            transmission = mapTransmission(car.transmission),
            price = car.price,
            location = car.location,
            color = mapColor(car.color),
            bodyType = mapBodyType(car.bodyType),
            steering = mapSteering(car.steering)
        )

}