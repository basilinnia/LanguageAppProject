package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.CircularProgressbar
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradientList

import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

@Composable
fun  LessonCard(title: String, progress:Float) {
    Row(modifier = Modifier
        .padding(vertical = 12.dp)
        .size(318.dp, 132.dp)
        .background(gradientList.random(), shape = RoundedCornerShape(10.dp))
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
                    text = title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(modifier = Modifier.padding(start = 15.dp, top = 30.dp)) {
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
            CircularProgressbar(progress)
        }
    }
}



