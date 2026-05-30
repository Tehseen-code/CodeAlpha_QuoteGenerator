package com.tehseen.quotegenerator.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tehseen.quotegenerator.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: QuoteRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState: StateFlow<DashboardUiState> = _uiState

    init {
        loadFreshQuote()
    }

    fun loadFreshQuote() {
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading
            repository.getRandomQuote()
                .onSuccess { freshQuote ->
                    _uiState.value = DashboardUiState.Success(freshQuote)
                }
                .onFailure { error ->
                    _uiState.value = DashboardUiState.Error(error.message ?: "Unknown Error State")
                }
        }
    }
}