package com.blueray.rowsandcolumns.todo_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ToDoListViewModel : ViewModel() {

    // Initialize with an empty list or some default data
    private val _state = MutableStateFlow<List<ToDoListState>>(emptyList())
    val state = _state.asStateFlow()

    fun onAction(action: ToDoListAction) {
        when (action) {
            is ToDoListAction.OnAddItemClick -> {
                _state.update { currentList ->
                    currentList + ToDoListState(
                        title = action.title,
                        description = action.description,
                        isChecked = action.isChecked
                    )
                }
            }

            is ToDoListAction.OnDeleteItemClick -> {
                _state.update { currentList ->
                    currentList.filterIndexed { index, _ ->
                        index != action.position
                    }
                }
            }
        }
    }
}