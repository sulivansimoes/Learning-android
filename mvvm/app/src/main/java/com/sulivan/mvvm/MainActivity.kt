package com.sulivan.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private val taskViewModel: TaskViewModel = TaskViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.adapter = TaskAdapter(this, taskViewModel.tasks.value ?: listOf())

        val taskList = findViewById<ListView>(R.id.taskList)
        taskList.adapter = this.adapter

        taskViewModel.tasks.observe(this){
            adapter.notifyDataSetChanged()
        }

        taskList.setOnItemLongClickListener { _, _, position, _ ->
            this.taskViewModel.deleteTask(position)
            true
        }

        taskList.setOnItemClickListener { _, _, position, _ ->
            this.taskViewModel.updateTask(position)
        }

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            val newTask = TaskModel("Nova Tarefa","descricao nova tarefa", false)
            this.taskViewModel.addTask(newTask)
        }
    }

}