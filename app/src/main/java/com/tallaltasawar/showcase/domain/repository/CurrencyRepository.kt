package com.tallaltasawar.showcase.domain.repository

import com.tallaltasawar.showcase.data.dto.CryptoCurrencyDto
import com.tallaltasawar.showcase.data.dto.CurrencyDetailDto

/*
 * The use of interface here is to able to mock these services in unit testing
 */
interface CurrencyRepository {
    suspend fun getCurrencies(): List<CryptoCurrencyDto>
    suspend fun getCurrencyDetails(currencyId: String): CurrencyDetailDto
}