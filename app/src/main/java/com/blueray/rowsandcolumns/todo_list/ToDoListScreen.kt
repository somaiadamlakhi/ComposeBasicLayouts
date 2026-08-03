package com.blueray.rowsandcolumns.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ToDoListScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<ToDoListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ToDoListDemo(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun ToDoListDemo(
    modifier: Modifier = Modifier,
    state: List<ToDoListState>,
    onAction: (ToDoListAction) -> Unit
) {


    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(state) { index, todoItem ->
                var isChecked by rememberSaveable(todoItem) {
                    mutableStateOf(todoItem.isChecked)
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .background(
                            Color.LightGray.copy(
                                alpha = 0.3f
                            )
                        )
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        Text(
                            text = todoItem.title,
                            textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None,
                            fontWeight = FontWeight.Bold
                        )
                        if (todoItem.description.isNotBlank()) {
                            Text(
                                text = todoItem.description,
                                textDecoration = if (isChecked) TextDecoration.LineThrough else TextDecoration.None,
                                fontSize = 12.sp
                            )
                        }
                    }

                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { newValue ->
                            isChecked = newValue
                        }
                    )

                    IconButton(onClick = {
                        onAction(ToDoListAction.OnDeleteItemClick(index))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.DarkGray
                        )
                    }
                }
            }
        }

        AddItem(
            onAction = onAction,
            modifier = Modifier.fillMaxWidth()
        )


    }

}

@Preview(showBackground = true)
@Composable
private fun ToDoListDemoPrev() {
    ToDoListDemo(
        state = listOf(),
        modifier = Modifier.fillMaxSize(),
        onAction = {}
    )
}

@Composable
fun AddItem(
    modifier: Modifier = Modifier,
    onAction: (ToDoListAction) -> Unit
) {
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (title.isNotBlank()) {
                    onAction(
                        ToDoListAction.OnAddItemClick(
                            title = title,
                            description = description,
                            isChecked = false
                        )
                    )
                    title = ""
                    description = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add")
        }
    }
}

