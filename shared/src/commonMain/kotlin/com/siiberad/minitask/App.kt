
package com.siiberad.minitask

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        val stateHolder = remember { TaskStateHolder() }
        val tasks by stateHolder.tasks.collectAsState()
        var input by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("MiniTask", style = MaterialTheme.typography.headlineMedium)

            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nama tugas") },
                singleLine = true
            )

            Button(
                onClick = {
                    stateHolder.addTask(input)
                    input = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tambah tugas")
            }

            Text("Daftar tugas (${tasks.size})")

            LazyColumn {
                items(tasks, key = { it.id }) { task ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = task.isCompleted,
                            onCheckedChange = {
                                stateHolder.toggleTask(task.id)
                            }
                        )

                        Text(task.title, modifier = Modifier.weight(1f))

                        TextButton(
                            onClick = { stateHolder.deleteTask(task.id) }
                        ) {
                            Text("Hapus")
                        }
                    }
                }
            }
        }
    }
}
