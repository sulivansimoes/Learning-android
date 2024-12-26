package com.sulivan.mvp

class TaskPresenter(
    private val view:TaskContract.View,

): TaskContract.Presenter{

    private val tasks = mutableListOf<TaskModel>()

    override fun getTasks() {
        view.showTasks(tasks)
    }

    override fun addTask(task: TaskModel) {
        task.id= tasks.size
        this.tasks.add(task)
        this.view.showTasks(tasks)
    }

    override fun updateTask(position: Int) {
        this.tasks[position].isCompleted = !tasks[position].isCompleted
        this.view.showTasks(tasks)
    }

    override fun deleteTask(task: TaskModel) {
        this.tasks.remove(task)
    }
}