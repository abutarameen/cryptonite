package com.tallaltasawar.showcase.presentation.ui.kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tallaltasawar.showcase.domain.model.CryptoCurrency
import com.tallaltasawar.showcase.ui.theme.kit.AvatarView

@Composable
fun CurrencyListItem(
    cryptoCurrency: CryptoCurrency,
    onCLick: (CryptoCurrency) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onCLick(cryptoCurrency) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Circular image view for coin icon
//        AvatarView(onClick = {}, cryptoCurrency = cryptoCurrency)
        // Rank, name and symbol
        Text(
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            text = "${cryptoCurrency.rank}. ${cryptoCurrency.name} ${cryptoCurrency.symbol}"
        )
        // Status (Green: Active Red: Inactive)
        cryptoCurrency.is_active?.let { isActive ->
            Text(
                style = MaterialTheme.typography.body2,
                text = if (isActive) "active" else "inactive",
                color = if (isActive) Color.Green else Color.Red,
                modifier = Modifier.align(CenterVertically)
            )
        }

    }
}

@Preview
@Composable
fun previewCurrencyListItem(){
    CurrencyListItem(cryptoCurrency = CryptoCurrency(), onCLick = {} )
}