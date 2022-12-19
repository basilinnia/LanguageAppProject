package com.appexamples.firebaseauthjetpackcompose.presentation.signup_screen

data class SignupState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
