package com.appexamples.firebaseauthjetpackcompose.presentation.quiz_screen


data class Question (
    val question: String,
    val optionList: List<String> ,
    val correctAnswer: Int
)