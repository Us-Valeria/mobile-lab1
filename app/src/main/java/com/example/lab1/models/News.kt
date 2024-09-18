package com.example.lab1.models

data class News(
    val id: Int,
    val title: String,
    var likes: Int = 0
)
