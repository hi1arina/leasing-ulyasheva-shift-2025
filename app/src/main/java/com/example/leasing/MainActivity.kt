package com.example.leasing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leasing.car_detail.data.repo.CarDetailRepositoryImpl
import com.example.leasing.car_detail.domain.usecase.GetCarDetailUseCase
import com.example.leasing.car_detail.presentation.CarDetailViewModel
import com.example.leasing.car_detail.ui.CarDetailScreen
import com.example.leasing.cars_catalog.data.repo.CarsCatalogRepositoryImpl
import com.example.leasing.cars_catalog.domain.usecase.GetCarsCatalogUseCase
import com.example.leasing.cars_catalog.domain.usecase.GetFilteredCarsUseCase
import com.example.leasing.cars_catalog.presentation.CarsCatalogViewModel
import com.example.leasing.cars_catalog.ui.CarsCatalogScreen
import com.example.leasing.ui.theme.LeasingTheme

class MainActivity : ComponentActivity() {

    private lateinit var carsCatalogViewModel: CarsCatalogViewModel
    private lateinit var carDetailViewModel: CarDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val carsCatalogRepositoryImpl = CarsCatalogRepositoryImpl()
        val carDetailRepositoryImpl = CarDetailRepositoryImpl()
        val getCarsCatalogUseCase = GetCarsCatalogUseCase(carsCatalogRepositoryImpl)
        val getFilteredCarsUseCase = GetFilteredCarsUseCase()
        val getCarDetailUseCase = GetCarDetailUseCase(carDetailRepositoryImpl)

        carsCatalogViewModel = CarsCatalogViewModel(getCarsCatalogUseCase, getFilteredCarsUseCase)
        carDetailViewModel = CarDetailViewModel(getCarDetailUseCase)

        setContent {
            LeasingTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "catalog") {
                    composable("catalog") {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            CarsCatalogScreen(
                                carsCatalogViewModel = carsCatalogViewModel,
                                modifier = Modifier.padding(innerPadding),
                                onCarClick = { carId ->
                                    navController.navigate("detail/$carId")
                                }
                            )
                        }
                    }
                    composable("detail/{carId}") { backStackEntry ->
                        val carId = backStackEntry.arguments?.getString("carId") ?: ""
                        CarDetailScreen(
                            carId = carId,
                            carDetailViewModel = carDetailViewModel,
                            modifier = Modifier.fillMaxSize(),
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}