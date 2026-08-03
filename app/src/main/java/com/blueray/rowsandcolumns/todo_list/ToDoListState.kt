package com.blueray.rowsandcolumns.todo_list

data class ToDoListState(
    val title: String = "",
    val description: String = "",
    val isChecked: Boolean = false
)