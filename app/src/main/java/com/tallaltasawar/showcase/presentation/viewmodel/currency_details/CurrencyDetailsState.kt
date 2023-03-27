package com.tallaltasawar.showcase.presentation.viewmodel.currency_details

import com.tallaltasawar.showcase.domain.model.CryptoCurrency
import com.tallaltasawar.showcase.domain.model.CurrencyDetail

data class CurrencyDetailsState(
    val loading: Boolean = false,
    val currency: CurrencyDetail? = null,
    val error: String = ""
)
