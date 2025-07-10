package com.example.leasing.car_detail.domain.entity

import com.example.leasing.cars_catalog.domain.entity.BodyType
import com.example.leasing.cars_catalog.domain.entity.Brand
import com.example.leasing.cars_catalog.domain.entity.Color
import com.example.leasing.cars_catalog.domain.entity.Media
import com.example.leasing.cars_catalog.domain.entity.Steering
import com.example.leasing.cars_catalog.domain.entity.Transmission

/* Аналогичные вопросы: правильно ли обращаться к классам из другой фичи?
* если бы была многомодульность, то их тоже нужно было бы вынести в common? */

data class CarDetail(
    val id: String,
    val name: String,
    val brand: Brand,
    val media: List<Media>,
    val transmission: Transmission,
    val price: Int,
    val location: String,
    val color: Color,
    val bodyType: BodyType,
    val steering: Steering,
    val rents: List<Rent>
)
