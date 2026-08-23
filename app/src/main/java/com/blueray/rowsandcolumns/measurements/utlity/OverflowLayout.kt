package com.blueray.rowsandcolumns.measurements.utlity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme
import kotlin.math.max

@Composable
fun OverflowLayout(
    isOverflowing: Boolean,
    modifier: Modifier = Modifier,
    mainContent: @Composable () -> Unit,
    overflowContent: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = {
            mainContent()
            if (isOverflowing) {
                overflowContent()
            }
        }
    ) { measurables, constraints ->
        // The layout should by default just occupy the minimum size it needs to fully fit its content
        
        // Measure main content
        val mainPlaceable = measurables[0].measure(constraints)
        
        // Measure overflow content only if it's visible (isOverflowing is true)
        val overflowPlaceable = if (isOverflowing && measurables.size > 1) {
            measurables[1].measure(constraints.copy(minHeight = 0))
        } else {
            null
        }

        val width = max(mainPlaceable.width, overflowPlaceable?.width ?: 0)
        val height = mainPlaceable.height + (overflowPlaceable?.height ?: 0)

        layout(width, height) {
            mainPlaceable.placeRelative(0, 0)
            overflowPlaceable?.placeRelative(0, mainPlaceable.height)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverflowLayoutPreview() {
    RowsAndColumnsTheme {
        OverflowLayoutList()
    }
}

@Composable
fun OverflowLayoutList() {
    val items = remember { List(20) { "Toggle Section $it" } }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items) { item ->
            var expanded by remember { mutableStateOf(false) }
            
            OverflowLayout(
                isOverflowing = expanded,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                mainContent = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = !expanded }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.weight(1f),
                            fontSize = 20.sp
                        )
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                },
                overflowContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Yellow)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Secret section for $item",
                            fontSize = 18.sp
                        )
                    }
                }
            )
        }
    }
}
