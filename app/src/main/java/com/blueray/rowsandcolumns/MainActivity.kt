package com.blueray.rowsandcolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.blueray.rowsandcolumns.ui.LocalSnackbarState
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }

            CompositionLocalProvider(LocalSnackbarState provides snackbarHostState) {
                RowsAndColumnsTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        snackbarHost = { SnackbarHost(hostState = LocalSnackbarState.current) }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SnackbarDemoButton()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SnackbarDemoButton() {
    val state = LocalSnackbarState.current
    val scope = rememberCoroutineScope()

    Button(
        onClick = {
            scope.launch {
                state.showSnackbar("Hello from anywhere!")
            }
        }
    ) {
        Text("Click me to show Snackbar")
    }
}

//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    enableEdgeToEdge()
//    setContent {
//        RowsAndColumnsTheme {
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//            ) { innerPadding ->
//
//                LaunchedEffectDemo(modifier = Modifier.padding(innerPadding))
//            }
//        }
//    }
//}
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            RowsAndColumnsTheme() {
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                ) { innerPadding ->
//                    val mindMapItems = remember {
//                        listOf(
//                            MindMapItem(
//                                title = "Hello world 1",
//                                percentageOffset = Offset(
//                                    x = 0f,
//                                    y = 0f
//                                )
//                            ),
//                            MindMapItem(
//                                title = "Hello world 2",
//                                percentageOffset = Offset(
//                                    x = 1f,
//                                    y = 0f
//                                )
//                            ),
//                            MindMapItem(
//                                title = "Hello world 3",
//                                percentageOffset = Offset(
//                                    x = 0.3f,
//                                    y = -0.5f
//                                )
//                            ),
//                            MindMapItem(
//                                title = "Hello world 4",
//                                percentageOffset = Offset(
//                                    x = -0.2f,
//                                    y = 1.5f
//                                )
//                            ),
//                        )
//                    }
//
//                    var mindMapOffset by remember {
//                        mutableStateOf(IntOffset.Zero)
//                    }
//                    LazyMindMap(
//                        items = mindMapItems,
//                        mindMapOffset = mindMapOffset,
//                        onDrag = { delta ->
//                            mindMapOffset += delta
//                        },
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}


//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    enableEdgeToEdge()
//    setContent {
//        RowsAndColumnsTheme() {
//            Scaffold(
//                modifier = Modifier.fillMaxSize(),
//            ) { innerPadding ->
//                var page by remember {
//                    mutableIntStateOf(0)
//                }
//                Column(
//                    modifier = Modifier
//                        .padding(innerPadding)
//                ) {
//                    SubcomposePagedRow(
//                        page = page,
//                        modifier = Modifier
//                            .background(Color.Red)
//                    ) {
//                        (1..1000).forEach {
//                            Box(
//                                modifier = Modifier
//                                    .height(100.dp)
//                                    .width(Random.nextInt(300).dp)
//                                    .background(Color(Random.nextInt()))
//                            )
//                        }
//                    }
//                    Button(onClick = {
//                        page++
//                    }) {
//                        Text("Go to next page")
//                    }
//                }
//            }
//        }
//    }
//}
//



