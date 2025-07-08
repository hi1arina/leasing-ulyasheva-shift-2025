package com.example.leasing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.leasing.cars_catalog.data.repo.CarsCatalogRepositoryImpl
import com.example.leasing.cars_catalog.domain.usecase.GetCarsCatalogUseCase
import com.example.leasing.cars_catalog.presentation.CarsCatalogViewModel
import com.example.leasing.cars_catalog.ui.CarsCatalogScreen
import com.example.leasing.ui.theme.LeasingTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: CarsCatalogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = CarsCatalogRepositoryImpl()
        val useCase = GetCarsCatalogUseCase(repository)
        viewModel = CarsCatalogViewModel(useCase)

        setContent {
            LeasingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarsCatalogScreen(
                        carsCatalogViewModel = viewModel, modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}