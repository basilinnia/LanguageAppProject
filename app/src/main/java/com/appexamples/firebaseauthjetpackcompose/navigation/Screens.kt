package com.appexamples.firebaseauthjetpackcompose.navigation

sealed class Screens(val route: String) {
    object LoginScreen : Screens(route = "Login_Screen")
    object SignUpScreen : Screens(route = "SignUp_Screen")
    object MainScreen: Screens(route = "main")
    object HomeScreen: Screens(route = "home")
    object CameraScreen: Screens(route = "camera")
    object LessonScreen: Screens(route= "lessons")
}