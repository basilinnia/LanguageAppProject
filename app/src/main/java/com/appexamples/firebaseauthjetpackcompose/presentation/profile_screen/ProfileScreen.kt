package com.appexamples.firebaseauthjetpackcompose.presentation.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.appexamples.firebaseauthjetpackcompose.data.GetData
import com.appexamples.firebaseauthjetpackcompose.data.Lesson


@Composable
fun ProfileScreen(){
    Column() {
        val lessons = remember { mutableStateListOf(Lesson()) }
        GetData(lessons = lessons)
        Column (modifier = Modifier.verticalScroll(rememberScrollState())
        ){
            lessons.forEach { lesson ->
                Box(modifier = Modifier
                    .size(200.dp)
                    .background(color = Color.White)) {
                    Text(text = lesson.lesson_name)
                }
            }
        }
    }
}