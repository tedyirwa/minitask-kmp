
package com.siiberad.minitask

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TaskRepositoryTest {

    @Test
    fun addTaskStoresTrimmedTitle() {
        val repository = TaskRepository()

        repository.addTask("  Belajar KMP  ")

        val tasks = repository.getTasks()

        assertEquals(1, tasks.size)
        assertEquals("Belajar KMP", tasks.first().title)
        assertFalse(tasks.first().isCompleted)
    }

    @Test
    fun blankTaskIsIgnored() {
        val repository = TaskRepository()

        repository.addTask("   ")

        assertTrue(repository.getTasks().isEmpty())
    }

    @Test
    fun toggleTaskChangesCompletionStatus() {
        val repository = TaskRepository()
        repository.addTask("Belajar Kotlin")

        val task = repository.getTasks().first()
        repository.toggleTask(task.id)

        assertTrue(repository.getTasks().first().isCompleted)
    }

    @Test
    fun deleteTaskRemovesTask() {
        val repository = TaskRepository()
        repository.addTask("Belajar KMP")

        val task = repository.getTasks().first()
        repository.deleteTask(task.id)

        assertTrue(repository.getTasks().isEmpty())
    }

    @Test
    fun stateHolderAddsTask() {
        val stateHolder = TaskStateHolder()

        stateHolder.addTask("Belajar KMP")

        assertEquals("Belajar KMP", stateHolder.tasks.value.first().title)
    }
}
