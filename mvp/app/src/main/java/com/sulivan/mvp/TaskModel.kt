package com.sulivan.mvp

data class TaskModel(
    var title:String,
    var description:String,
    var isCompleted: Boolean,
    var id:Int? = null

)
