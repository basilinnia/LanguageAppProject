package com.appexamples.firebaseauthjetpackcompose.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appexamples.firebaseauthjetpackcompose.data.AuthRepository
import com.appexamples.firebaseauthjetpackcompose.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    val _googleState = mutableStateOf(GoogleSignInState())
    val  googleState: State<GoogleSignInState> = _googleState

    fun googleSignIn(credential: AuthCredential) = viewModelScope.launch {
        repository.googleSignIn(credential).collect{result ->
            when(result){
                is Resource.Success -> {
                    _googleState.value = GoogleSignInState(isSuccess = result.data.toString())
                }
                is Resource.Loading -> {
                    _googleState.value = GoogleSignInState(isLoading =true)
                }
                is Resource.Error -> {
                    _googleState.value = GoogleSignInState(isError = result.message)
                }
            }
        }
    }
    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{result ->
            when(result){
                is Resource.Success -> {
                    _loginState.send(LoginState(isSuccess = "Sign In Success"))
                }
                is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading =true))
                }
                is Resource.Error -> {
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }
}