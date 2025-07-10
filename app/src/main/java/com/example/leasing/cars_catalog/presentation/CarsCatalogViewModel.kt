package com.example.leasing.cars_catalog.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leasing.cars_catalog.domain.usecase.GetCarsCatalogUseCase
import com.example.leasing.cars_catalog.domain.usecase.GetFilteredCarsUseCase
import kotlinx.coroutines.launch


class CarsCatalogViewModel(
    val getCarsCatalog: GetCarsCatalogUseCase,
    val getFilteredCars: GetFilteredCarsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<CarsCatalogState>(CarsCatalogState.Initial)
    val state: LiveData<CarsCatalogState> = _state

    fun loadCars() {
        viewModelScope.launch {
            _state.value = CarsCatalogState.Loading
            try {
                val response = getCarsCatalog.invoke(
                    null, null, null, null, null, null, null, 1, 10
                )
                _state.value = CarsCatalogState.Content(cars = response.data, searchState = SearchState.Found(search = "", cars = response.data))
            } catch (e: Exception) {
                //потом добавлю state error
            }
        }
    }

    fun searchCars(search: String) {
        val currentState = _state.value as? CarsCatalogState.Content ?: return
        val filteredCars = getFilteredCars.invoke(search, currentState.cars)
        _state.value = currentState.copy(searchState = if (filteredCars.isEmpty()) {
            SearchState.NotFound(search)
        } else {
            SearchState.Found(search, filteredCars)
        })
    }
}