package com.tallaltasawar.showcase.data.remote

import com.tallaltasawar.showcase.data.dto.CryptoCurrencyDto
import com.tallaltasawar.showcase.data.dto.CurrencyDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {
    @GET("/v1/coins")
    suspend fun getCryptoCurrencies(): List<CryptoCurrencyDto>

    @GET("/v1/coins/{currencyId}")
    suspend fun getCurrencyDetails(@Path("currencyId") currencyId: String): CurrencyDetailDto
}