package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun LazyList(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Color.White),
        contentPadding = PaddingValues(5.dp),
        reverseLayout = true,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        stickyHeader {
            Text(
                "Section A", modifier = modifier
                    .background(Color.Green)
                    .fillMaxWidth()
            )
        }
        items(100) { i ->
            Text("Item $i")
        }

        stickyHeader {
            Text(
                "Section B", modifier = modifier
                    .background(Color.Green)
                    .fillMaxWidth()
            )
        }
        items(100) { i ->
            Text("Item ${i + 100}")
        }


    }
}

@Preview
@Composable
private fun LazyListPrev() {
    LazyRowDemo()
}

@Composable
fun LazyRowDemo(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) {
            Box(
                modifier = modifier
                    .size(100.dp)
                    .background(Color(Random.nextInt())
                    ))


        }
    }
}