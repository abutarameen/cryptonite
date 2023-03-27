package com.tallaltasawar.showcase.data.repossitory

import com.tallaltasawar.showcase.data.remote.CryptoAPI
import com.tallaltasawar.showcase.data.dto.CryptoCurrencyDto
import com.tallaltasawar.showcase.data.dto.CurrencyDetailDto
import com.tallaltasawar.showcase.domain.repository.CurrencyRepository
import javax.inject.Inject

class DefaultCurrencyRepository @Inject constructor(
    private val api: CryptoAPI
) : CurrencyRepository {
    override suspend fun getCurrencies(): List<CryptoCurrencyDto> {
        return api.getCryptoCurrencies()
    }

    override suspend fun getCurrencyDetails(currencyId: String): CurrencyDetailDto {
        return api.getCurrencyDetails(currencyId = currencyId)
    }

}