package com.blueray.rowsandcolumns.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun ProduceStateDemo(modifier: Modifier = Modifier) {
    val counter by produceState(0) {
        while (true) {
            delay(1000L)
            value++
        }
    }

    Text(
        counter.toString(),
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview(showBackground = true)
@Composable
private fun ProduceStateDemoPrev() {
    ProduceStateDemo()
}