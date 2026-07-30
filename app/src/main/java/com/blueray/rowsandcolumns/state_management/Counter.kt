package com.blueray.rowsandcolumns.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Counter(modifier: Modifier = Modifier) {
    var items by rememberSaveable {
        mutableStateOf(
            listOf("Item")
        )
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                items += ("Item")
            }
        ) {
            Text("Add Item")
        }

        Text(items.toString(), modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterPrev() {
    Counter()
}