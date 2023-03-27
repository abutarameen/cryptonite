package com.tallaltasawar.showcase.presentation.viewmodel.crypto_currencies

import com.tallaltasawar.showcase.domain.model.CryptoCurrency

data class CryptoCurrenciesState(
    val loading: Boolean = false,
    val currencies: List<CryptoCurrency> = emptyList(),
    val error: String = ""
)
