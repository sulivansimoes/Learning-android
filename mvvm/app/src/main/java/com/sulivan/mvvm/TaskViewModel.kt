package com.sulivan.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    private val tasks_ : MutableLiveData<MutableList<TaskModel>> = MutableLiveData(mutableListOf())
    val tasks: LiveData<MutableList <TaskModel>> = tasks_

    fun addTask(task: TaskModel){
        val currentTasks = this.tasks_.value ?: mutableListOf()
        currentTasks.add(task)
        this.tasks_.value = currentTasks
    }

    fun updateTask(position:Int){
        val currentTasks = this.tasks_.value ?: mutableListOf()
        currentTasks[position].isCompleted = !currentTasks[position].isCompleted
        this.tasks_.value = currentTasks
    }

    fun deleteTask(position:Int){
        val currentTasks = this.tasks_.value ?: mutableListOf()
        currentTasks.remove(currentTasks[position])
        this.tasks_.value = currentTasks
    }
}