package com.example.leasing.cars_catalog.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.leasing.cars_catalog.presentation.CarsCatalogState
import com.example.leasing.cars_catalog.presentation.CarsCatalogViewModel

@Composable
fun CarsCatalogScreen(
    carsCatalogViewModel: CarsCatalogViewModel, modifier: Modifier = Modifier, onCarClick: (String) -> Unit
) {
    val state by carsCatalogViewModel.state.observeAsState(CarsCatalogState.Initial)

    LaunchedEffect(Unit) {
        carsCatalogViewModel.loadCars()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        when (val currentState = state) {
            is CarsCatalogState.Initial -> {}

            is CarsCatalogState.Loading -> {}

            is CarsCatalogState.Content -> CarsCatalogContent(
                state = currentState, onSearchValueChange = carsCatalogViewModel::searchCars, onCarClick = onCarClick
            )
        }
    }
}