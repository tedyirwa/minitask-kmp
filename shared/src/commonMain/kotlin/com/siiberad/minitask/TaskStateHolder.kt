
package com.siiberad.minitask

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskStateHolder(
    private val repository: TaskRepository = TaskRepository()
) {
    private val _tasks = MutableStateFlow(repository.getTasks())

    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    fun addTask(title: String) {
        repository.addTask(title)
        refreshTasks()
    }

    fun toggleTask(id: String) {
        repository.toggleTask(id)
        refreshTasks()
    }

    fun deleteTask(id: String) {
        repository.deleteTask(id)
        refreshTasks()
    }

    private fun refreshTasks() {
        _tasks.value = repository.getTasks()
    }
}
