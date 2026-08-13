package com.blueray.rowsandcolumns.measurements.utlity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SizeModifierDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Red),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("")
                .fillMaxWidth(0.5f)

                .background(Color.Yellow)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(100.dp)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SizeModifierDemoPrev() {
    SizeModifierDemo()
}

fun Modifier.printConstraints(tag: String): Modifier = this.layout { measurable, constraints ->
    println("Tag: $tag, Constraints: $constraints")
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(0, 0)
    }
}