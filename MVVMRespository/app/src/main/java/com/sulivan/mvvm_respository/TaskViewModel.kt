package com.sulivan.mvvm_respository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel constructor(
    private val taskRepository:TaskRepository
): ViewModel(){

    private val tasks_: MutableLiveData<List<TaskModel>> = MutableLiveData(taskRepository.get())
    val tasks : LiveData<List<TaskModel>> = tasks_

    fun add(task:TaskModel) {
        tasks_.value = taskRepository.add(task)
    }

    fun delete(position:Int) {
        tasks_.value = taskRepository.delete(position)
    }

    fun update(position:Int) {
        tasks_.value = taskRepository.update(position)
    }
}