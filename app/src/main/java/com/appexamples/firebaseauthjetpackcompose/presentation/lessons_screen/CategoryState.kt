package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.PopularLessons


@Composable
fun All() {
    Column {
        PopularLessons()
    }
}

@Composable
fun Beginner() {
    Text(text = "Beginner")
}

@Composable
fun Intermediate() {
    Text(text = "Intermediate")
}

@Composable
fun Advanced() {
    Text(text = "Advanced")
}