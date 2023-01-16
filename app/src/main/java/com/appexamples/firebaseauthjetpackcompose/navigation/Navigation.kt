package com.appexamples.firebaseauthjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appexamples.firebaseauthjetpackcompose.SplashScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen.BottomBarScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.login_screen.LoginScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.MainScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.quiz_screen.Constants
import com.appexamples.firebaseauthjetpackcompose.presentation.quiz_screen.QuizScreen
import com.appexamples.firebaseauthjetpackcompose.presentation.signup_screen.SignupScreen

@Composable
fun Navigation(
     navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = BottomBarScreen.MainScreen.route ) {
            composable(route = Screens.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(route = Screens.SignUpScreen.route) {
                SignupScreen(navController = navController)
            }
        composable(route = Screens.MainScreen.route) {
            MainScreen()
        }
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.FlashcardScreen.route) {
            QuizScreen(Constants.getQuestions() ,navController = navController)
        }
        composable("dictionary") {
            QuizScreen(Constants.getQuestions() ,navController = navController)
        }
        composable(route = Screens.MainScreen.route) {
            MainScreen()
        }
        composable("quizzes") {
            QuizScreen(Constants.getQuestions() ,navController = navController)
        }
    }
}