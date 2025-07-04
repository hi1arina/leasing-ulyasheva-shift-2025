package com.example.leasing.cars_catalog.data.converter

import com.example.leasing.cars_catalog.data.model.CarModel
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.Car

object CarConverter {

    private fun mapBrand(brand: String): Brand = when (brand.trim()) {
        "Haval" -> Brand.Haval
        "Hyundai" -> Brand.Hyundai
        "Volkswagen" -> Brand.Volkswagen
        "Kia" -> Brand.Kia
        "Geely" -> Brand.Geely
        "Mercedes" -> Brand.Mercedes
        "Garden car" -> Brand.GardenCar
        "Grocery cart" -> Brand.GroceryCart
        "Haier" -> Brand.Haier
        else -> Brand.Invalid
    }

    fun convert(car: CarModel) : Car =
        Car (
            id = car.id,
            name = car.name,
            brand = mapBrand(car.brand),
            media = car.media.map { MediaConverter.convert(it) },
            transmission = car.transmission,
            price = car.price,
            location = car.location,
            color = car.color,
            bodyType = car.bodyType,
            steering = car.steering
        )

}