package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Style
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.nikhilchaudhari.library.NeuInsets
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

@Composable
fun MainNavButtons() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxHeight()) {
            ActivityBox(icon  = Icons.Outlined.Quiz,  title =  "Quizzes", 160, 180)
            ActivityBox(icon = Icons.Outlined.Article, title = "Grammar", 160, 140)
        }
        Column(modifier = Modifier.fillMaxHeight()) {
            ActivityBox(icon  = Icons.Outlined.Translate,  title =  "Translate", 150,120 )
            ActivityBox(icon = Icons.Default.Style, title = "Flashcards", 150, 200)
        }
    }
}


@Composable
fun ActivityBox(icon: ImageVector, title: String,w: Int, h: Int){
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF8B3C3C),
            Color(0xFFFF3E4E)
        ))

    Column(modifier = Modifier
        .padding( end = 25.dp ,bottom = 25.dp)
        .clip(RoundedCornerShape(16.dp))
        .bounceClick()
        .width(w.dp)
        .height(h.dp)
        .neumorphic(
            lightShadowColor = Color.Gray,
            darkShadowColor = Color.DarkGray,
            elevation = 6.dp,
            strokeWidth = 2.dp,
            neuInsets = NeuInsets(2.dp, 2.dp),
            neuShape = Pressed.Rounded()
        )
        .background(gradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
        Text(text = title, fontSize = 18.sp, color = Color.Black)
    }
}