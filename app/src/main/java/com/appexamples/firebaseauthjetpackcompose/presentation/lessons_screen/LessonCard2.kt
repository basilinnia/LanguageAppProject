package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appexamples.firebaseauthjetpackcompose.ui.theme.card_bg
import io.ktor.http.*

@Composable
fun LessonCard2(iconPainter: Int ,lesson: Lesson) {
   Column(
      Modifier
         .size(220.dp)
         .background(Color.White)){

       Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 45.dp, top = 15.dp)) {
          Image(painter = painterResource(id = iconPainter), contentDescription =" ", modifier = Modifier.size(50.dp))
          Text(text = lesson.lesson_name, fontSize = 25.sp)
          Text(text ="You completed 74%", fontSize = 15.sp)
          LinearProgressIndicator(
             progress = 0.6f,
             modifier = Modifier
                .background(shape = RoundedCornerShape(7.dp), color = Color.LightGray)
                .size(126.dp, 11.dp)
          )
       }
      Row(modifier = Modifier
         .padding(start = 65.dp, top = 40.dp)
         .clip(RoundedCornerShape(5.dp))
         .background(color = card_bg)) {
         Text(text = "Start Practice ", modifier= Modifier.padding(top = 6.dp, start = 6.dp))
         Icon(
            imageVector = Icons.Outlined.ArrowForward,
            modifier = Modifier.size(36.dp),
            contentDescription = " "
         )
      }

   }
}