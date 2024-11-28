package com.example.workoutdiary

data class Routine(
    val name: String,
    val exercises: MutableList<Exercise> = mutableListOf()
)
