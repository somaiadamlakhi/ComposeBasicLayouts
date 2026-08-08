package com.blueray.rowsandcolumns.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OffsetModifier() {
    Column(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)

    ) {

        /**
         * change X and Y to test the offset concept
         */
        Text(
            "Hello World",
            modifier = Modifier
                .offset(
                    x = 25.dp,
                    y = 20.dp
                )
                .background(Color.Yellow)
        )
        Text(
            "Hello World",
            modifier = Modifier
                .background(Color.Green)

        )
    }
}

@Preview
@Composable
private fun OffsetModifierPrev() {
    OffsetModifier()
}