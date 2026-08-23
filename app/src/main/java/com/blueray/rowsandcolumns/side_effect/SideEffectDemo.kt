package com.blueray.rowsandcolumns.side_effect

import android.widget.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier) {

    var counter by remember {
        mutableIntStateOf(0)
    }
    Button(onClick = {
        counter++
    }) {
        Text("Counter $counter")
    }
}

@Preview
@Composable
private fun SideEffectDemoPrev() {
    SideEffectDemo()
}