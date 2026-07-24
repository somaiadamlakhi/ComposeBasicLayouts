package com.blueray.rowsandcolumns.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blueray.rowsandcolumns.ui.theme.RowsAndColumnsTheme
import kotlin.math.roundToInt


//horizontalArrangement = Arrangement.spacedBy(
//space = 20.dp,
//alignment = Alignment.CenterHorizontally
//)
@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center

    ) {
//        horizontalArrangement = Arrangement.aligned { size, space, layoutDirection ->
//            (space * 0.5).roundToInt()
//        }
//        Text(
//            "Hello World !",
//            fontSize = 40.sp,
//            modifier = Modifier
//                .width(150.dp)
//                .alignBy(LastBaseline)
//        )
//        Text(
//            "Hello World !",
//            fontSize = 20.sp,
//            modifier = Modifier.alignByBaseline()
//        )

        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(100.dp)
        )
        Column(
            modifier = Modifier.fillMaxHeight()
        )  {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .height(50.dp)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.Green)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun RowColumnDemoPreview() {
    RowsAndColumnsTheme {
        RowColumnDemo()
    }
}