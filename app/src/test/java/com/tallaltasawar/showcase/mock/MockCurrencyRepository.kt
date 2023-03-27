package com.tallaltasawar.showcase.mock

import com.tallaltasawar.showcase.data.dto.CryptoCurrencyDto
import com.tallaltasawar.showcase.data.dto.CurrencyDetailDto
import com.tallaltasawar.showcase.domain.repository.CurrencyRepository

class MockCurrencyRepository(): CurrencyRepository {
    override suspend fun getCurrencies(): List<CryptoCurrencyDto> {
        return currencies
    }

    override suspend fun getCurrencyDetails(currencyId: String): CurrencyDetailDto {
        return btcDetail
    }

}
