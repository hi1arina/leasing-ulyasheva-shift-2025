package com.example.leasing.car_detail.data.model

import com.example.leasing.cars_catalog.data.model.MediaModel

data class CarDetailModel(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaModel>, // можно ли использовать тут MediaModel, если сам класс в cars_catalog? если бы была многомодульность, то нужно было бы выносить этот класс в common?
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String,
    val rents: List<RentModel>
)