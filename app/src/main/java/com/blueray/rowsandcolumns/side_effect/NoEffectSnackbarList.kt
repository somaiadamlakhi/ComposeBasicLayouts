package com.blueray.rowsandcolumns.side_effect

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A Composable that displays a list and shows a snackbar when scrolled to the bottom.
 * 
 * Constraint Checklist:
 * - 100% free of side-effects.
 * - No effect handlers (LaunchedEffect, SideEffect, etc.) used.
 * - Purely driven by state and composition.
 */
@Composable
fun NoEffectSnackbarList(
    items: List<String>,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    // We use derivedStateOf to calculate the "at bottom" condition.
    // This is a pure calculation based on existing state.
    val isAtBottom by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val visibleItems = layoutInfo.visibleItemsInfo
            
            if (visibleItems.isEmpty()) {
                false
            } else {
                val lastItem = visibleItems.last()
                // The user is at the bottom if:
                // 1. The last item in the list is visible
                // 2. The bottom of that item is at or beyond the viewport end
                // 3. (Optional) The list is actually scrollable (to fulfill "Once the user scrolled")
                lastItem.index == items.size - 1 && 
                        lastItem.offset + lastItem.size <= layoutInfo.viewportEndOffset
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = {
            // Instead of triggering an effect to call snackbarHostState.showSnackbar(),
            // we purely compose the Snackbar when the state condition is met.
            if (isAtBottom) {
                Snackbar(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(text = "Scrolled to the bottom!")
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(items) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}
