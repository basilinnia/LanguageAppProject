package com.appexamples.firebaseauthjetpackcompose.presentation.bottom_bar_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Share
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object MainScreen : BottomBarScreen(
        route = "main",
        title = "Main",
        icon = Icons.Default.Home
    )

    object LessonScreen : BottomBarScreen(
        route = "lessons",
        title = "Lessons",
        icon = Icons.Default.School
    )

    object CameraScreen : BottomBarScreen(
        route = "camera",
        title = "Camera",
        icon = Icons.Outlined.PhotoCamera
    )

    object DictionaryScreen : BottomBarScreen(
        route = "dictionary",
        title = "Dictionary",
        icon = Icons.Default.Book
    )
    object ProfileScreen  : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

}