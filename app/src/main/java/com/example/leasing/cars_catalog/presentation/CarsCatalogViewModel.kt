package com.example.leasing.cars_catalog.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leasing.cars_catalog.domain.usecase.GetCarsCatalogUseCase
import kotlinx.coroutines.launch


class CarsCatalogViewModel(
    val getCarsCatalog: GetCarsCatalogUseCase
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
                _state.value = CarsCatalogState.Content(cars = response.data)
            } catch (e: Exception) {
                //потом добавлю state error
            }
        }
    }
}