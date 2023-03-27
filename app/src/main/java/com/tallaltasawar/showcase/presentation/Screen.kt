package com.tallaltasawar.showcase.presentation

sealed class Screen(val route: String) {
    object CurrencyListScreen: Screen("currency_list_screen")
    object CurrencyDetailsScreen: Screen("currency_details_screen")
}