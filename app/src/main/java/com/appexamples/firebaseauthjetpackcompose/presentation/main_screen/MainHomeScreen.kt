package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import MainNavButtons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBar
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBarNavGraph
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bg_color
import com.appexamples.firebaseauthjetpackcompose.ui.theme.darkBlue
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightBlue


@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
 Scaffold(
     bottomBar = { BottomBar(navController = navController) },
     floatingActionButton = {
         FloatingActionButton(
             backgroundColor = Color.DarkGray
             ,onClick = {
             // FAB onClick
             navController.navigate(Screens.CameraScreen.route)
         }) {
             Icon(tint = Color.Black, imageVector = Icons.Outlined.PhotoCamera, contentDescription = "Camera")
         }
     },
     scaffoldState = scaffoldState,
     isFloatingActionButtonDocked = true,
     floatingActionButtonPosition = FabPosition.Center
 ) {
        BottomBarNavGraph(navController = navController)
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(color = bg_color)
            .fillMaxWidth()
            .padding(20.dp)
        ) {
        Row(modifier = Modifier.padding(top = 20.dp)) {
            Column {
                Text(
                    text = "Hello, Ecem",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(end = 150.dp)
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
                    .size(60.dp)
                    .clip(CircleShape)
            )
        }
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(vertical = 45.dp)
                .height(160.dp)
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
        MainNavButtons()

    }
}


