package com.example.todoapp.models

data class Model(
    var name:String,
    var description:String,
    var degree:MySpinner? = null,
    var createData:String,
    var dedline:String,
    var level:String
)

