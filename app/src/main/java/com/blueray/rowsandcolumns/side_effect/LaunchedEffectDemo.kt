package com.blueray.rowsandcolumns.side_effect

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableStateOf(0)
    }

    val snackBarHostState = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        scope.launch {
            snackBarHostState.showSnackbar("IS GRANTED = $isGranted")
        }
    }
    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.RECORD_AUDIO)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState
            )
        }
    ) { innerPadding ->

        Button(
            onClick = {
                counter++
//                if (counter % 2 == 0) {
//                    scope.launch {
//                        snackBarHostState.showSnackbar("$counter  is an even number !")
//                    }
//                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .wrapContentSize()
        ) {
            Text("Counter $counter")
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun LaunchedEffectDemoPrev() {
    LaunchedEffectDemo()
}