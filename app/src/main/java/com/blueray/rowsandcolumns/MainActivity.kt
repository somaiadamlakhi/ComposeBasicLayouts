package com.blueray.rowsandcolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import com.blueray.rowsandcolumns.measurements.custom_layout.LazyMindMap
import com.blueray.rowsandcolumns.measurements.custom_layout.MindMapItem
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowsAndColumnsTheme() {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    val mindMapItems = remember {
                        listOf(
                            MindMapItem(
                                title = "Hello world 1",
                                percentageOffset = Offset(
                                    x = 0f,
                                    y = 0f
                                )
                            ),
                            MindMapItem(
                                title = "Hello world 2",
                                percentageOffset = Offset(
                                    x = 1f,
                                    y = 0f
                                )
                            ),
                            MindMapItem(
                                title = "Hello world 3",
                                percentageOffset = Offset(
                                    x = 0.3f,
                                    y = -0.5f
                                )
                            ),
                            MindMapItem(
                                title = "Hello world 4",
                                percentageOffset = Offset(
                                    x = -0.2f,
                                    y = 1.5f
                                )
                            ),
                        )
                    }

                    var mindMapOffset by remember {
                        mutableStateOf(IntOffset.Zero)
                    }
                    LazyMindMap(
                        items = mindMapItems,
                        mindMapOffset = mindMapOffset,
                        onDrag = { delta ->
                            mindMapOffset += delta
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}


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



