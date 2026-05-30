package com.tehseen.quotegenerator.feature.splash

sealed interface SplashUiState {
    object Loading : SplashUiState
    object NavigateToDashboard : SplashUiState
}