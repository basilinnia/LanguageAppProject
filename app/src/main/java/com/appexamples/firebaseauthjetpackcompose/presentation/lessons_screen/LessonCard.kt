package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.CircularProgressbar
import com.appexamples.firebaseauthjetpackcompose.ui.theme.card_bg
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bottom_color

import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

@Composable
fun  LessonCard(lesson: Lesson, iconPainter: Int) {
    Row(modifier = Modifier
        .padding(vertical = 12.dp)
        .size(358.dp, 132.dp)
        .background(bottom_color, shape = RoundedCornerShape(10.dp))
        .neumorphic(
            lightShadowColor = Color.Gray,
            elevation = 6.dp,
            strokeWidth = 2.dp,
            neuShape = Pressed.Rounded()
        ),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
            Column {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 23.dp),
                    text = lesson.lesson_name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(modifier = Modifier.padding(start = 15.dp, top = 30.dp).clip(RoundedCornerShape(5.dp)).background(color = card_bg)) {
                    Text(text = "Go to the lesson   ", modifier= Modifier.padding(top = 6.dp))
                    Icon(
                        imageVector = Icons.Outlined.ArrowForward,
                        modifier = Modifier.size(36.dp),
                        contentDescription = " "
                    )
                }
            }

        Column(
            modifier = Modifier
                .padding( top = 20.dp, end = 25.dp)
        ) {
            CircularProgressbar((1..100).random().toFloat())
        }
    }
}



