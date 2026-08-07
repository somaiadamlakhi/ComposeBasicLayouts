package com.blueray.rowsandcolumns.modifiers

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

data object StarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val centerX = size.width / 2f
            val centerY = size.height / 2f
            val outerRadius = size.width / 2f
            val innerRadius = outerRadius / 2.5f // Adjust this for a "thinner" or "thicker" star
            val numPoints = 5
            val angleStep = Math.PI / numPoints

            for (i in 0 until numPoints * 2) {
                // Alternate between outer and inner radius
                val radius = if (i % 2 == 0) outerRadius else innerRadius
                val angle = i * angleStep - Math.PI / 2

                val x = centerX + Math.cos(angle).toFloat() * radius
                val y = centerY + Math.sin(angle).toFloat() * radius

                if (i == 0) moveTo(x, y) else lineTo(x, y)
            }
            close()
        }
        return Outline.Generic(path)
    }
}