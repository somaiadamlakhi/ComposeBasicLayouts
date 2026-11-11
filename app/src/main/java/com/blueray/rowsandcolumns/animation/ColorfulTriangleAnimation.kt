package com.blueray.rowsandcolumns.animation

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.sqrt

@Composable
fun ColorfulTriangleAnimation(
    colors: List<Color>,
    width: Dp,
    modifier: Modifier = Modifier
) {
    val height = width * (sqrt(3f) / 2f)

    val infiniteTransition = rememberInfiniteTransition(label = "triangle_transition")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = EaseInOut),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation_progress"
    )

    Box(
        modifier = modifier.size(width, height),
        contentAlignment = Alignment.Center
    ) {
        colors.forEachIndexed { index, color ->
            val targetRotation = (index + 1) * 360f

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        // Pivot exactly in the middle horizontally, 2/3 down vertically
                        transformOrigin = TransformOrigin(0.5f, 2f / 3f)
                        rotationZ = progress * targetRotation
                    }
            ) {
                val path = Path().apply {
                    moveTo(size.width / 2f, 0f)       // Top Center
                    lineTo(size.width, size.height)   // Bottom Right
                    lineTo(0f, size.height)           // Bottom Left
                    close()
                }
                
                drawPath(
                    path = path,
                    color = color
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ColorfulTriangleAnimationPreview() {
    Box(
        modifier = Modifier.size(400.dp),
        contentAlignment = Alignment.Center
    ) {
        ColorfulTriangleAnimation(
            colors = listOf(
                Color(0xFFE91E63).copy(alpha = 0.5f),
                Color(0xFF2196F3).copy(alpha = 0.5f),
                Color(0xFF4CAF50).copy(alpha = 0.5f),
                Color(0xFFFFC107).copy(alpha = 0.5f),
                Color(0xFF9C27B0).copy(alpha = 0.5f),
                Color(0xFF00BCD4).copy(alpha = 0.5f)
            ),
            width = 200.dp
        )
    }
}
