
package com.siiberad.minitask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    MaterialTheme {
        val repository = remember { TaskRepository() }
        val tasks = remember { mutableStateListOf<Task>() }
        var input by remember { mutableStateOf("") }

        fun refreshTasks() {
            tasks.clear()
            tasks.addAll(repository.getTasks())
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "MiniTask",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nama tugas") },
                singleLine = true
            )

            Button(
                onClick = {
                    repository.addTask(input)
                    input = ""
                    refreshTasks()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tambah tugas")
            }

            Text(
                text = "Daftar tugas (${tasks.size})",
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(tasks, key = { it.id }) { task ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = task.isCompleted,
                            onCheckedChange = {
                                repository.toggleTask(task.id)
                                refreshTasks()
                            }
                        )

                        Text(
                            text = task.title,
                            modifier = Modifier.weight(1f)
                        )

                        Spacer(Modifier.width(4.dp))

                        TextButton(
                            onClick = {
                                repository.deleteTask(task.id)
                                refreshTasks()
                            }
                        ) {
                            Text("Hapus")
                        }
                    }
                }
            }
        }
    }
}
