package com.tallaltasawar.showcase.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tallaltasawar.showcase.presentation.Screen
import com.tallaltasawar.showcase.presentation.ui.kit.CurrencyListItem
import com.tallaltasawar.showcase.presentation.viewmodel.crypto_currencies.CryptoCurrenciesViewModel

@Composable
fun CurrencyListScreen(
    navController: NavController,
    viewModel: CryptoCurrenciesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { navController.navigate(Screen.BtcUsdGraphScreen.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "View BTC/USD Graph")
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.currencies) { currency ->
                    CurrencyListItem(cryptoCurrency = currency, onCLick = {
                        navController.navigate(Screen.CurrencyDetailsScreen.route + "/${currency.id}")
                    })
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(text = state.error, color = Color.Red)
        }
        if (state.loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}