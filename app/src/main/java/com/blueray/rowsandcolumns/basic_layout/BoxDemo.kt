package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.blueray.rowsandcolumns.R

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ) {

        Image(painterResource(R.drawable.kermit), "")
Box(modifier =
modifier
    .matchParentSize()
    .background(
    brush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color.Black
        )
    )
)){}
        IconButton(
            onClick = {},
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
        ) {
            Icon(imageVector = Icons.Default.Star, "Favourite", tint = Color.White)
        }
    }
}

@Preview
@Composable
private fun BoxDemoPrev() {
    BoxDemo()
}

