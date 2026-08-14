package com.blueray.rowsandcolumns.measurements.utlity

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxWithConstraintsDemo(modifier: Modifier = Modifier) {
    BoxWithConstraints (
        modifier = modifier.width(100.dp)
    ){
        if (constraints.hasFixedWidth)
            Text("Fixed Width !")
        else
            Text("Dynamic Width !")
    }

}

@Preview(showBackground = true)
@Composable
private fun BoxWithConstraintsDemoPrev() {
    BoxWithConstraintsDemo()
}