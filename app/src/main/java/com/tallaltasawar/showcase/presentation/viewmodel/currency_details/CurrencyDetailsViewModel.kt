package com.tallaltasawar.showcase.presentation.viewmodel.currency_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallaltasawar.showcase.common.Constants
import com.tallaltasawar.showcase.common.Resource
import com.tallaltasawar.showcase.domain.usecase.GetCurrencyDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailsViewModel @Inject constructor(
    private val getCurrencyDetailsUseCase: GetCurrencyDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf<CurrencyDetailsState>(CurrencyDetailsState())
    val state: State<CurrencyDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CURRENCY_ID)?.let { currencyId ->
            getCurrencies(currencyId)
        }
    }

    private fun getCurrencies(currencyId: String) {
        getCurrencyDetailsUseCase(currencyId).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CurrencyDetailsState(currency = resource.data)
                }
                is Resource.Failure -> {
                    _state.value = CurrencyDetailsState(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CurrencyDetailsState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}