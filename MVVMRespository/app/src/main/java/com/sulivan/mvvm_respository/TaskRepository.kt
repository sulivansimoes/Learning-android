package com.sulivan.mvvm_respository

class TaskRepository(
    private val taskDataSource: TaskDataSource
) {

    /*
    * Em caso de varias fontes de dados, aqui que seria feito a tomada de decisão
    * de qual fonte de dado acionar.
    * Por exemplo, cache, api e etc.
    * */

    fun get() = taskDataSource.get()

    fun add(task:TaskModel) = taskDataSource.add(task)

    fun delete(position:Int) = taskDataSource.delete(position)

    fun update(position:Int) = taskDataSource.update(position)
}