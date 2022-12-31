package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import MainNavButtons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.LessonCard
import com.appexamples.firebaseauthjetpackcompose.ui.theme.darkBlue


@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Header()
        Spacer(modifier = Modifier.height(50.dp))
        MainNavButtons()
        PopularLessons()
        }
}

@Composable
fun PopularLessons(){
    Column(modifier = Modifier
        .padding(top = 40.dp, start = 5.dp, end=5.dp)
    ) {
         Text(text = "Popular Lessons For You", color= Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        LessonCard()
        Spacer(modifier = Modifier.height(10.dp))
        LessonCard()
        Spacer(modifier = Modifier.height(10.dp))
        LessonCard()
        Spacer(modifier = Modifier.height(10.dp))
        LessonCard()
        Spacer(modifier = Modifier.height(10.dp) )
        LessonCard()
        Spacer(modifier = Modifier.height(75.dp))
    }
}

/*
@Composable
fun FirstCard(){
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(vertical = 45.dp)
            .height(120.dp)
            .fillMaxWidth(),
        backgroundColor = darkBlue
    ) {
        Row(modifier = Modifier
            .clickable(onClick = { })
        ) {
            Column(modifier = Modifier.padding(30.dp)) {
                Text(text = "LESSON NAME")
            }
        }
    }
}
*/

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(top = 30.dp)) {
            Column {
                Text(
                    text = "Hello, Ecem",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(end = 130.dp)
                )
                Text(
                    text = "Let's learn something today",
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                )
            }
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "User profile photo",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )
        }
    }
}