package com.blueray.rowsandcolumns.modifiers

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClickableModifierDemo(modifier: Modifier = Modifier) {

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed by interactionSource.collectIsPressedAsState()
    /**
     * apply clickable always before padding
     * if the modifier is clickable
     */
    Box(
        modifier = modifier
            .size(100.dp)
            .background(if (isPressed) Color.Blue else Color.LightGray)
            .clickable(
                interactionSource,
                LocalIndication.current
            ) {
                println("Hi")
            },
        contentAlignment = Alignment.Center,
    ) {
        Text("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
private fun ClickableModifierDemoPrev() {
    ClickableModifierDemo()
}