package com.blueray.rowsandcolumns.measurements.utlity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

val boundedConstraints = Constraints(
    minWidth = 0,
    maxWidth = 2000,
    minHeight = 0,
    maxHeight = 3000,
)

var unBoundedConstant = Constraints()

val exactConstraints = Constraints(
    minWidth = 50,
    maxWidth = 50,
    minHeight = 50,
    maxHeight = 50
)

val combinedConstraints = Constraints(
    minWidth = 50,
    maxWidth = 50,
    minHeight = 100,
    maxHeight = Constraints.Infinity
)

@Composable
fun MeasurementsDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Text(
            "This is a text",
            modifier = Modifier.background(Color.Yellow)
        )
        Text(
            "This is another text",
            modifier = Modifier.background(Color.Green)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun MeasurementsDemoPrev() {
    MeasurementsDemo()
}