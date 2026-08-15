package com.blueray.rowsandcolumns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.blueray.rowsandcolumns.todo_list.ToDoListScreenRoot
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowsAndColumnsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToDoListScreenRoot(
                        modifier = Modifier.padding(
                            innerPadding
                        )
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
