package com.tallaltasawar.showcase.data.dto

import com.tallaltasawar.showcase.domain.model.CryptoCurrency

data class CryptoCurrencyDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CryptoCurrencyDto.toCryptoCurrency() = CryptoCurrency(
    id = id,
    name = name,
    is_active = is_active,
    rank = rank,
    symbol = symbol
)