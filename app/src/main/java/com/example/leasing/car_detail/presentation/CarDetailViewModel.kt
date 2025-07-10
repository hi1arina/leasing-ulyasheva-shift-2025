package com.example.leasing.car_detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leasing.car_detail.domain.usecase.GetCarDetailUseCase
import kotlinx.coroutines.launch

class CarDetailViewModel(
    private val getCarDetailUseCase: GetCarDetailUseCase
) : ViewModel() {

    private val _state = MutableLiveData<CarDetailState>(CarDetailState.Initial)
    val state: LiveData<CarDetailState> = _state

    fun loadCarDetail(carId: String) {
        _state.value = CarDetailState.Loading
        viewModelScope.launch {
            try {
                val car = getCarDetailUseCase(carId)
                _state.value = CarDetailState.Content(car)
            } catch (e: Exception) {
                //потом добавлю state error
            }
        }
    }
}