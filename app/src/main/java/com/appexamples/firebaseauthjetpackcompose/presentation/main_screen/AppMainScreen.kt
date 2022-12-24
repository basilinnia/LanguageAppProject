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
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightBottomBarColor


@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
 Scaffold(
     backgroundColor = bg_color,
     bottomBar = { BottomBar(navController = navController) },
     floatingActionButton = {
         FloatingActionButton(
             backgroundColor = Color.LightGray
             ,onClick = {
             // FAB onClick
             navController.navigate(Screens.CameraScreen.route)
         }) {
             Icon(tint = lightBottomBarColor, imageVector = Icons.Outlined.PhotoCamera, contentDescription = "Camera")
         }
     },
     scaffoldState = scaffoldState,
     isFloatingActionButtonDocked = true,
     floatingActionButtonPosition = FabPosition.Center
 ) {
        BottomBarNavGraph(navController = navController)
    }
}


