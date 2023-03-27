package com.tallaltasawar.showcase.mock

import com.tallaltasawar.showcase.data.dto.CryptoCurrencyDto
import com.tallaltasawar.showcase.data.dto.CurrencyDetailDto
import com.tallaltasawar.showcase.data.dto.Links
import com.tallaltasawar.showcase.data.dto.Whitepaper

val btcDetail = CurrencyDetailDto(
    name = "bitcoin",
    id = "btc",
    symbol = "BTC",
    rank = 1,
    is_active = true,
    is_new = true,
    type = "",
    org_structure = "",
    proof_type = "",
    tags = listOf(),
    team = listOf(),
    whitepaper = Whitepaper("",""),
    open_source = true,
    message = "",
    links = Links(listOf(), listOf(), listOf(), listOf(), listOf(), listOf()),
    logo = "",
    links_extended = listOf(),
    description = "",
    development_status = "",
    first_data_at = "",
    hardware_wallet = true,
    hash_algorithm = "",
    last_data_at = "",
    started_at = ""
)

val btc = CryptoCurrencyDto(
    name = "bitcoin",
    id = "btc",
    symbol = "BTC",
    rank = 1,
    is_active = true,
    is_new = true,
    type = ""
)

val eth = CryptoCurrencyDto(
    name = "Ethereum",
    id = "eth",
    symbol = "ETH",
    rank = 2,
    is_active = true,
    is_new = true,
    type = ""
)

val usdt = CryptoCurrencyDto(
    name = "Thther",
    id = "usdt",
    symbol = "USDT",
    rank = 3,
    is_active = true,
    is_new = true,
    type = ""
)

val currencies = listOf<CryptoCurrencyDto>(btc, eth, usdt)
