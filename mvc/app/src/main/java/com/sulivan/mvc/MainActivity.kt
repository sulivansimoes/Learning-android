package com.sulivan.mvc

import android.media.TimedText
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Clock

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private var controller = TaskController()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.adapter = TaskAdapter(this, this.controller.getTasks())

        val taskList = findViewById<ListView>(R.id.taskList)

        taskList.adapter = adapter

        taskList.setOnItemLongClickListener { _, _, position, _ ->
            controller.removeTask(position)
            adapter.notifyDataSetChanged()
            true
        }

        taskList.setOnItemClickListener { _, _, position, _ ->
            controller.updateTask(position)
            adapter.notifyDataSetChanged()
        }

        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            val  newTask = TaskModel("Nova tarefa","Descricao", false)
            controller.addTask(newTask)
            adapter.notifyDataSetChanged()

        }

    }

}