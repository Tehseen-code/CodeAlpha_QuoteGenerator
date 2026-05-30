package com.tehseen.quotegenerator.feature.dashboard

import com.tehseen.quotegenerator.data.model.Quote

sealed interface DashboardUiState {
    object Loading : DashboardUiState
    data class Success(val quote: Quote) : DashboardUiState
    data class Error(val errorMessage: String) : DashboardUiState
}