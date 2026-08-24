package com.blueray.rowsandcolumns.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun DisposableEffectDemo(modifier: Modifier = Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner.lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    println("ON START was called ")
                }

                Lifecycle.Event.ON_PAUSE -> {
                    println("ON PAUSE was called ")
                }

                Lifecycle.Event.ON_CREATE -> {
                    println("ON CREATE was called ")
                }

                Lifecycle.Event.ON_RESUME -> {
                    println("ON RESUME was called ")
                }

                Lifecycle.Event.ON_DESTROY -> {
                    println("ON DESTROY was called ")
                }

                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            println("OBSERVER WAS Disposed ")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DisposableEffectPrev() {
    DisposableEffectDemo()
}