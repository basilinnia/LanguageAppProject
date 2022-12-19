package com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.presentation.camera_screen.CameraScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.LessonsScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.HomeScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.MainScreen


@Composable
fun BottomBarNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.MainScreen.route
    ) {
        composable(route = BottomBarScreen.LessonScreen.route) {
            LessonsScreen()
        }
        composable(route = BottomBarScreen.MainScreen.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.CameraScreen.route) {
            CameraScreen()
        }
    }
}
