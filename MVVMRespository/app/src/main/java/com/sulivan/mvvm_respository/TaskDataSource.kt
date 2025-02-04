package com.sulivan.mvvm_respository

class TaskDataSource constructor(
    private val taskNetWorkLayer: TaskNetWorkLayer
) {
    fun get():List<TaskModel> = taskNetWorkLayer.get()

    fun add(task:TaskModel) = taskNetWorkLayer.add(task)

    fun delete(position:Int) = taskNetWorkLayer.delete(position)

    fun update(position:Int) = taskNetWorkLayer.update(position)
}