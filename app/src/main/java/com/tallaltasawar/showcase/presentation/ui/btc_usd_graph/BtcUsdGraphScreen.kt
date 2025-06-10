package com.tallaltasawar.showcase.presentation.ui.btc_usd_graph

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.rotate

@Composable
fun BtcUsdGraphScreen() {
    val btcPrices = listOf(40000f, 40500f, 39800f, 41000f, 42000f, 41500f, 43000f)
    val usdPrices = List(btcPrices.size) { 1f }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "BTC / USD Comparison",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(modifier = Modifier.weight(1f)) {
            Text(
                text = "Price",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .rotate(-90f)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.body2
            )
            LineChart(
                btcPrices,
                usdPrices,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        Text(
            text = "Time",
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(8.dp))
        Legend()
    }
}

@Composable
private fun LineChart(btc: List<Float>, usd: List<Float>, modifier: Modifier = Modifier) {
    val maxValue = (btc + usd).maxOrNull() ?: 0f
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val stepX = width / (btc.size - 1)
        val btcPath = Path()
        val usdPath = Path()
        btc.forEachIndexed { i, value ->
            val x = stepX * i
            val y = height - (value / maxValue) * height
            if (i == 0) btcPath.moveTo(x, y) else btcPath.lineTo(x, y)
        }
        usd.forEachIndexed { i, value ->
            val x = stepX * i
            val y = height - (value / maxValue) * height
            if (i == 0) usdPath.moveTo(x, y) else usdPath.lineTo(x, y)
        }
        drawLine(Color.LightGray, start = androidx.compose.ui.geometry.Offset(0f, height), end = androidx.compose.ui.geometry.Offset(width, height))
        drawLine(Color.LightGray, start = androidx.compose.ui.geometry.Offset(0f, 0f), end = androidx.compose.ui.geometry.Offset(0f, height))

        drawPath(btcPath, color = Color.Green, style = Stroke(width = 5f))
        drawPath(usdPath, color = Color.Blue, style = Stroke(width = 5f))
    }
}

@Composable
private fun Legend() {
    Row(modifier = Modifier.padding(top = 4.dp)) {
        LegendItem(color = Color.Green, label = "BTC")
        Spacer(modifier = Modifier.width(16.dp))
        LegendItem(color = Color.Blue, label = "USD")
    }
}

@Composable
private fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(color)
        )
        Spacer(Modifier.width(4.dp))
        Text(text = label, style = MaterialTheme.typography.body2)
    }
}
