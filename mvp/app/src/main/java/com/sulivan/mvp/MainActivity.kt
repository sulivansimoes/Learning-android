package com.sulivan.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sulivan.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskContract.View {

    private lateinit var presenter:TaskContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        this.binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        this.presenter = TaskPresenter(this)

        this.binding.addTaskButton.setOnClickListener {
            val newTask = TaskModel("Nova tarefa","Descricao tarefa", false)
            this.presenter.addTask(newTask)
        }
    }

    override fun showTasks(tasks: List<TaskModel>) {

        val adapter = TaskAdapter(this, tasks)
        this.binding.taskList.adapter = adapter

        this.binding.taskList.setOnItemLongClickListener { _, _, position, _ ->
           this.presenter.deleteTask(tasks[position])
           true
        }

        this.binding.taskList.setOnItemClickListener { _, _, position, _ ->
           this.presenter.updateTask(position)
        }

    }
}