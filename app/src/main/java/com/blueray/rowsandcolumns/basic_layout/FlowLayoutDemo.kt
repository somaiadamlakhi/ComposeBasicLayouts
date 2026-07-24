package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo(modifier: Modifier = Modifier) {

    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Color.White),
        maxItemsInEachRow = 4,
        maxLines = 5,
        overflow = FlowRowOverflow.expandIndicator {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown,"")
            }
        },
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        for (i in 1..30)
            AssistChip(onClick = {}, label = { Text("Item $i") })
    }
}

@Preview
@Composable
private fun FlowLayoutPrev() {
    FlowLayoutDemo()
}