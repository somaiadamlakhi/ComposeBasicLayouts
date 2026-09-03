package com.blueray.rowsandcolumns.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * CompositionLocal used to provide a [SnackbarHostState] down the tree.
 */
val LocalSnackbarState = staticCompositionLocalOf<SnackbarHostState> {
    error("No SnackbarHostState provided! Make sure to wrap your content in a CompositionLocalProvider.")
}
