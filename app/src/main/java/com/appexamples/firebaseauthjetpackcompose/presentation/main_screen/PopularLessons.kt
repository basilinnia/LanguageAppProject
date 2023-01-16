package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.Lesson
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.LessonCard


@Composable
fun PopularLessons() {
    val viewModel = viewModel<MainViewModel>()
    val lessons = remember { mutableStateOf<List<Lesson>>(emptyList()) }
    viewModel.lessons.observeForever {
        lessons.value = it
    }

    Column(modifier = Modifier
        .padding(top = 20.dp)
    ) {
        Text(text = "Pick a Lesson", color= Color.Black, fontSize = 24.sp)
        lessons.value.shuffled().slice(1..lessons.value.size /10 ).forEach { lesson ->
            LessonCard(lesson = lesson,  R.drawable.book2)
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}