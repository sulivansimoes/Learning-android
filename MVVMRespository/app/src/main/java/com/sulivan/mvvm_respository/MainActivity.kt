package com.sulivan.mvvm_respository

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskWorkLayer: TaskNetWorkLayer = TaskNetWorkLayer()
        val taskDataSource: TaskDataSource = TaskDataSource(taskWorkLayer)
        val taskRepository: TaskRepository = TaskRepository(taskDataSource)
        val taskViewModel: TaskViewModel = TaskViewModel(taskRepository)

        this.adapter = TaskAdapter(this,taskViewModel.tasks.value ?: listOf() )

        val taskList= findViewById<ListView>(R.id.taskList)

        taskList.adapter = this.adapter

        //escuta alterações no livedata
        taskViewModel.tasks.observe(this){
            adapter.notifyDataSetChanged()
        }


        taskList.setOnItemLongClickListener { _, _, position, _ ->
            taskViewModel.delete(position)
            true
        }

        taskList.setOnItemClickListener { _, _, position, _ ->
            taskViewModel.update(position)
        }

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            val newTask = TaskModel("Nova tarefa","descricao tarefa", false)
            taskViewModel.add(newTask)
        }

    }
}