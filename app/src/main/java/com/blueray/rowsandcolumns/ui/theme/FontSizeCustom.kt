package com.blueray.rowsandcolumns.ui.theme

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

fun getFontSize(
    windowClass: WindowSizeClass
): TextUnit {
    return when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 18.sp
        WindowWidthSizeClass.MEDIUM -> 24.sp
        WindowWidthSizeClass.EXPANDED -> 28.sp
        else -> 18.sp
    }
}