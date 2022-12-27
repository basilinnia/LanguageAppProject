package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightBlue
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightColor

@Composable
fun  LessonCard() {
    Surface(modifier = Modifier
        .size(368.dp, 72.dp)
        , elevation = 8.dp, shape = RoundedCornerShape(10.dp))
    {
                    Column(modifier = Modifier
                        .padding(horizontal = 6.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "lesson",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                       Row() {
                           Text(
                               modifier = Modifier.padding(end= 100.dp),
                               text = """
                            Lorem ipsum dolor sit amet,consectetur adipiscing 
                            elit.In aliquam metus neque, nec iaculis lacus a
                            liquam quis. Aenean in dignissim arcu. Phasellus 
                            varius magna non congue imperdiet... 
                        """.trimIndent(),
                               fontSize = 8.sp,
                               fontFamily = FontFamily.SansSerif,
                               color = Color.DarkGray,
                               fontWeight = FontWeight.Normal
                           )
                           Icon(imageVector = Icons.Outlined.ArrowForward, modifier = Modifier.size(100.dp), contentDescription = " " )
                       }
                }


        }
}

