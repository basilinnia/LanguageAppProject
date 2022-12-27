package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



@Composable
fun All() {
    Text(text = "ALL")
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