package com.appexamples.firebaseauthjetpackcompose.presentation.signup_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appexamples.firebaseauthjetpackcompose.data.AuthRepository
import com.appexamples.firebaseauthjetpackcompose.presentation.login_screen.LoginState
import com.appexamples.firebaseauthjetpackcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel  @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
        val _signupState = Channel<SignupState>()
        val signupState = _signupState.receiveAsFlow()

        fun registerUser(email: String, password: String) = viewModelScope.launch {
            repository.registerUser(email, password).collect{result ->
                when(result){
                    is Resource.Success -> {
                        _signupState.send(SignupState(isSuccess = "Sign Up Success"))
                    }
                    is Resource.Loading -> {
                        _signupState.send(SignupState(isLoading =true))
                    }
                    is Resource.Error -> {
                        _signupState.send(SignupState(isError = result.message))
                    }
                }
            }
        }
    }
