package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import MainNavButtons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.data.Lesson
import com.appexamples.firebaseauthjetpackcompose.data.lessonList
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.LessonCard


@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(start = 30.dp, end = 15.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(50.dp))
        MainNavButtons()
        PopularLessons()
        }
}

@Composable
fun PopularLessons(){
    val lessonList = lessonList()
    val lessons = remember { lessonList.shuffled().slice(1 .. lessonList.size/10) }

    Column(modifier = Modifier
        .padding(top = 20.dp)
    ) {
        Text(text = "Pick a Lesson", color= Color.White, fontSize = 24.sp)
        Column(){
            for(it in lessons){
                    LessonCard(lesson = it)
                    println("HEY BURAYA BAK LAN"+it.color)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        Spacer(modifier = Modifier.height(100.dp))
    }
}





@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Row {
            Column {
                Text(
                    text = "Hello, Ecem",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 35.sp,
                    modifier = Modifier.padding(end = 90.dp)
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