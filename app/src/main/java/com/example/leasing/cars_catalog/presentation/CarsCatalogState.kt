package com.example.leasing.cars_catalog.presentation

import com.example.leasing.cars_catalog.domain.entity.Car

sealed interface CarsCatalogState {

    data object Initial : CarsCatalogState

    data object Loading : CarsCatalogState

    data class Content(val cars: List<Car>) : CarsCatalogState

}