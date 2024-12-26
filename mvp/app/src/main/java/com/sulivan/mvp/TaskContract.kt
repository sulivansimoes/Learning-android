package com.sulivan.mvp

interface TaskContract {

    interface View{
        fun showTasks(tasks:List<TaskModel>)
    }

    interface Presenter{
        fun getTasks()
        fun addTask(task : TaskModel)
        fun updateTask(position:Int)
        fun deleteTask(task : TaskModel)
    }
}