package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBar
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBarNavGraph
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bg_color
import com.appexamples.firebaseauthjetpackcompose.ui.theme.fabColor



@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
 Scaffold(
     backgroundColor = bg_color,
     bottomBar = { BottomBar(navController = navController) },
     floatingActionButton = {
         FloatingActionButton(
             backgroundColor = fabColor,
             onClick = {
             // FAB onClick
             navController.navigate(Screens.CameraScreen.route)
         }) {
             Icon(tint = Color.DarkGray, imageVector = Icons.Outlined.PhotoCamera, contentDescription = "Camera")
         }
     },
     scaffoldState = scaffoldState,
     isFloatingActionButtonDocked = true,
     floatingActionButtonPosition = FabPosition.Center
 ) {
        BottomBarNavGraph(navController = navController)
    }
}


