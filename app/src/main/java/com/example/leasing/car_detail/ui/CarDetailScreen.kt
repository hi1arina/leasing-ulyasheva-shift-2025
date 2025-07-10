package com.example.leasing.car_detail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.leasing.car_detail.presentation.CarDetailState
import com.example.leasing.car_detail.presentation.CarDetailViewModel

@Composable
fun CarDetailScreen(
    carId: String,
    carDetailViewModel: CarDetailViewModel,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    val state by carDetailViewModel.state.observeAsState(CarDetailState.Initial)

    LaunchedEffect(Unit) {
        carDetailViewModel.loadCarDetail(carId)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        when (val currentState = state) {
            is CarDetailState.Initial -> {}
            is CarDetailState.Loading -> {}
            is CarDetailState.Content -> CarDetailContent(car = currentState.car, onBackClick = onBackClick)
        }
    }
}