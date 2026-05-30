package com.tehseen.quotegenerator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tehseen.quotegenerator.data.repository.QuoteRepositoryImpl
import com.tehseen.quotegenerator.feature.dashboard.DashboardScreen
import com.tehseen.quotegenerator.feature.dashboard.DashboardViewModel
import com.tehseen.quotegenerator.feature.splash.SplashScreen
import com.tehseen.quotegenerator.feature.splash.SplashUiState
import com.tehseen.quotegenerator.feature.splash.SplashViewModel

@Composable
actual fun NavGraph() {
    val navController = rememberNavController()
    val quoteRepository = QuoteRepositoryImpl()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // 1. Splash Screen Destination Routing Block
        composable(Screen.Splash.route) {
            val splashViewModel: SplashViewModel = viewModel { SplashViewModel() }
            val state by splashViewModel.uiState.collectAsState()

            LaunchedEffect(state) {
                if (state is SplashUiState.NavigateToDashboard) {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            }
            SplashScreen()
        }

        // 2. Main Dashboard Layout Routing Block
        composable(Screen.Dashboard.route) {
            val dashboardViewModel: DashboardViewModel = viewModel {
                DashboardViewModel(quoteRepository)
            }
            DashboardScreen(viewModel = dashboardViewModel)
        }
    }
}