package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.ui.graphics.Brush
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradientList

data class Lesson (
    var lesson_name: String =" ",
    var color: Brush = gradientList[4],
    var words: List<String> = listOf()
)
