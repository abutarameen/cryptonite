package com.tallaltasawar.showcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tallaltasawar.showcase.presentation.Screen
import com.tallaltasawar.showcase.presentation.ui.CurrencyListScreen
import com.tallaltasawar.showcase.presentation.ui.currency_detail_screen.CurrencyDetailScreen
import com.tallaltasawar.showcase.presentation.ui.btc_usd_graph.BtcUsdGraphScreen
import com.tallaltasawar.showcase.ui.theme.ShowcaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowcaseTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CurrencyListScreen.route
                    ) {
                        composable(
                            route = Screen.CurrencyListScreen.route
                        ) {
                            CurrencyListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CurrencyDetailsScreen.route + "/{currency_id}"
                        ) {
                            CurrencyDetailScreen()
                        }
                        composable(
                            route = Screen.BtcUsdGraphScreen.route
                        ) {
                            BtcUsdGraphScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h1
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShowcaseTheme {
        Greeting("Android")
    }
}