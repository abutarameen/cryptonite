package com.tallaltasawar.showcase.domain.model

data class CryptoCurrency(
    val id: String? = "0",
    val is_active: Boolean? = false,
    val name: String? = "CryptoCurrency",
    val rank: Int? = 0,
    val symbol: String? = "none",
    val logo: String? = ""
)