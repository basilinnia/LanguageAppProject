package com.appexamples.firebaseauthjetpackcompose.presentation.activity_navigation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Style
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBarScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.bounceClick
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradient1
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradient2
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradient3
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradient4
import me.nikhilchaudhari.library.NeuInsets
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed
import org.checkerframework.checker.units.qual.h

@Composable
fun MainNavButtons() {
    Column {
        Text("Pick an activity", fontSize = 26.sp, modifier = Modifier.padding(bottom = 10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxHeight()) {
                ActivityBox(icon  = Icons.Outlined.Quiz,  title =  "Quizzes", 160, 180, gradient1, Screens.QuizScreen.route)
                ActivityBox(icon = Icons.Outlined.Book, title = "Dictionary", 160, 140, gradient2, Screens.CameraScreen.route)
            }
            Column(modifier = Modifier.fillMaxHeight()) {
                ActivityBox(icon  = Icons.Outlined.Translate,  title =  "Translate", 150,120, gradient3, null )
                ActivityBox(icon = Icons.Default.Style, title = "Flashcards", 150, 200, gradient4, Screens.FlashcardScreen.route)
            }
        }
    }

}

@Composable
fun ActivityBox(icon: ImageVector, title: String,w: Int, h: Int, gradient: Brush, route: String?,
                navController: NavHostController =  rememberNavController()) {
        Column(modifier = Modifier
            .padding(end = 25.dp, bottom = 25.dp)
            .clip(RoundedCornerShape(16.dp))
            .bounceClick()
            .clickable (
                enabled = true,
                onClick = {
                    if (route != null) {
                        navController.navigate(route)
                    }
                })
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
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Text(text = title, fontSize = 20.sp, color = Color.Black)
        }
    }


