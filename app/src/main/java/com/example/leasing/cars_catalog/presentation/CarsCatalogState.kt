package com.example.leasing.cars_catalog.presentation

import com.example.leasing.cars_catalog.domain.entity.Car

sealed interface CarsCatalogState {

    data object Initial : CarsCatalogState

    data object Loading : CarsCatalogState

    data class Content(val cars: List<Car>, val searchState: SearchState) : CarsCatalogState

}

sealed interface SearchState {

    val search: String

    data class Found(
        override val search: String,
        val cars: List<Car>
        ) : SearchState

    data class NotFound(override val search: String) : SearchState
}