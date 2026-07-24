package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun LazyGridDemo(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier
            .background(Color.White),
//        verticalArrangement = Arrangement.spacedBy(15.dp),
//        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(100) {
            Box(
                modifier = modifier
                    .width(
                        Random.nextInt(50..100).dp
                    )
                    .clip(RoundedCornerShape(15.dp))
                    .height(100.dp)
                    .background(Color(Random.nextInt()))
            )
        }
    }
}

@Preview
@Composable
private fun LazyGridPrev() {
    LazyGridDemo()
}