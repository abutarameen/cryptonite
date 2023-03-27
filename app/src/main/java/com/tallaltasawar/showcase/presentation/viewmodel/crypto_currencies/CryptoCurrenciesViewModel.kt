package com.tallaltasawar.showcase.presentation.viewmodel.crypto_currencies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tallaltasawar.showcase.common.Resource
import com.tallaltasawar.showcase.domain.usecase.GetCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoCurrenciesViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase
) : ViewModel() {
    private val _state = mutableStateOf<CryptoCurrenciesState>(CryptoCurrenciesState())
    val state: State<CryptoCurrenciesState> = _state

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        getCurrenciesUseCase().onEach { listResource ->
            when(listResource) {
                is Resource.Success -> {
                    _state.value = CryptoCurrenciesState(currencies = listResource.data ?: emptyList())
                }
                is Resource.Failure -> {
                    _state.value = CryptoCurrenciesState(error = listResource.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CryptoCurrenciesState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}