package com.tallaltasawar.showcase.ui.theme.kit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.tallaltasawar.showcase.R
import com.tallaltasawar.showcase.domain.model.CryptoCurrency

/*
 * Avatar circular view (third party) its been made clickable if it might ne needed in the future
 */
@Composable
fun AvatarView(onClick: (CryptoCurrency) -> Unit, cryptoCurrency: CryptoCurrency) {
    GlideImage(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(CircleShape)
            .clickable(enabled = true, onClick = {onClick(cryptoCurrency)}),
        imageModel = cryptoCurrency.logo?: "https://avatars.githubusercontent.com/u/27887884?v=4",
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Crop,
        // shows an image with a circular revealed animation.
        circularReveal = CircularReveal(duration = 250),
        // shows an error ImageBitmap when the request failed.
        error = ImageBitmap.imageResource(id = R.drawable.avater)
    )
}