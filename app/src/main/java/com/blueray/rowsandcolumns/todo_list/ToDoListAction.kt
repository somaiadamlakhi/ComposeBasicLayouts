package com.blueray.rowsandcolumns.todo_list

sealed interface ToDoListAction {
    data class OnAddItemClick(
        val title: String,
        val description: String,
        val isChecked: Boolean
    ) : ToDoListAction

    data class OnDeleteItemClick(val position: Int) : ToDoListAction


}