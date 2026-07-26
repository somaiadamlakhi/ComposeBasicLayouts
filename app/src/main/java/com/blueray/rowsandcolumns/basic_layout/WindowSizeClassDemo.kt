package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices.NEXUS_7
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun WindowSizeClassDemo(modifier: Modifier = Modifier) {

    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    Scaffold(

    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (windowClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT,
                WindowWidthSizeClass.MEDIUM -> {
                    MyLazyList(modifier)
                }

                WindowWidthSizeClass.EXPANDED -> {
                    Row(
                        modifier = modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(3f)
                                .background(Color.Red)
                        ) {

                            Text("Menu Option #1")
                            Text("Menu Option #2")
                            Text("Menu Option #3")


                        }

                        MyLazyList(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(7f),
                        )
                    }
                }
            }

        }

    }
}


@Preview(
    showBackground = true,
    device = NEXUS_7
)
@Composable
private fun WindowSizeClassDemoPrev() {
    WindowSizeClassDemo()
}

@Composable
fun MyLazyList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(40) {
            Text(
                "Item $it",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}