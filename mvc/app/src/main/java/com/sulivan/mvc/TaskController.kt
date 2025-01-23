package com.sulivan.mvc

class TaskController {

    private val tasks = mutableListOf<TaskModel>()

    fun getTasks():List<TaskModel>{
        return this.tasks
    }

    fun addTask(task:TaskModel){
        task.id = this.tasks.size
        this.tasks.add(task)
    }

    fun updateTask(position:Int){
        tasks[position].isCompleted = !this.tasks[position].isCompleted
    }

    fun removeTask(position:Int){
        this.tasks.remove(this.tasks[position])
    }
}