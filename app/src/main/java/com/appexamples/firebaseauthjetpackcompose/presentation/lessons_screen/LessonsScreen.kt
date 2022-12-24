package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bg_color

@Composable
fun LessonsScreen() {
     Box(modifier = Modifier
         .fillMaxSize()
        ) {
         Header()
         LessonCard()

     }

}
@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(260.dp)
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(
                    topEndPercent = 0,
                    topStartPercent = 0,
                    bottomEndPercent = 5,
                    bottomStartPercent = 5
                )
            )
    )
}