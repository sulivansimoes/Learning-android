package com.sulivan.mvvm_respository

class TaskNetWorkLayer {

    private val tasks: MutableList<TaskModel> = mutableListOf()

    fun get():List<TaskModel> = this.tasks

    fun add(task:TaskModel): List<TaskModel>{
        tasks.add(task)
        return tasks
    }

    fun delete(position : Int): List<TaskModel>{
        tasks.remove(tasks[position])
        return tasks
    }

    fun update(position: Int): List<TaskModel>{
        tasks[position].isCompleted = !tasks[position].isCompleted
        return tasks
    }



}