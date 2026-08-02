package com.blueray.rowsandcolumns.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val todoListItems = listOf(
    Todo(
        "Bring out the trash",
        "Better to do before wife come back home", false
    ),
    Todo(
        "Hi my sweet",
        "I am still not sure", true
    ),
    Todo(
        "Take care",
        "The baby my be wake up at any time", false
    )
)

@Composable
fun ToDoListDemo(modifier: Modifier = Modifier) {


    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        todoListItems.forEach { todoItem ->
            item {
                var isChecked by rememberSaveable {
                    mutableStateOf(todoItem.isChecked)
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .background(Color.LightGray.copy(
                            alpha = 0.3f
                        ))
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {

                        Text(
                            text = todoItem.title,
                            textDecoration =
                                if (isChecked) TextDecoration.LineThrough
                                else TextDecoration.None
                        )
                        Text(
                            text = todoItem.description,
                            textDecoration =
                                if (isChecked) TextDecoration.LineThrough
                                else TextDecoration.None
                        )
                    }

                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { newValue ->
                            isChecked = newValue
                        }
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
private fun ToDoListDemoPrev() {
    ToDoListDemo()
}

data class Todo(val title: String, val description: String, val isChecked: Boolean)