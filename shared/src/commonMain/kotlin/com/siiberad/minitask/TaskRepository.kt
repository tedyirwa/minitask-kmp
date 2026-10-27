
package com.siiberad.minitask

class TaskRepository {

    private val _tasks = mutableListOf<Task>()

    fun getTasks(): List<Task> = _tasks.toList()

    fun addTask(title: String) {
        val trimmedTitle = title.trim()

        if (trimmedTitle.isBlank()) return

        val task = Task(
            id = nextId(),
            title = trimmedTitle
        )

        _tasks.add(task)
    }

    fun toggleTask(id: String) {
        val index = _tasks.indexOfFirst { it.id == id }

        if (index == -1) return

        val currentTask = _tasks[index]

        _tasks[index] = currentTask.copy(
            isCompleted = !currentTask.isCompleted
        )
    }

    fun deleteTask(id: String) {
        _tasks.removeAll { it.id == id }
    }

    private var idCounter = 0

    private fun nextId(): String {
        idCounter += 1
        return idCounter.toString()
    }
}
