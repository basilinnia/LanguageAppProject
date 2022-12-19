package com.appexamples.firebaseauthjetpackcompose.presentation.login_screen

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.NonNull
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.data.Constant.ServerClient
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightBlue
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import com.google.firebase.auth.OAuthProvider.newBuilder
import com.google.firebase.inject.Provider
import com.google.firebase.ktx.Firebase
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {

    val googleSignInState = viewModel.googleState.value

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val result = account.getResult(ApiException::class.java)
                val credentials = GoogleAuthProvider.getCredential(result.idToken, null)
                viewModel.googleSignIn(credentials)
            } catch (it: ApiException) {
                println(it)
            }
        }

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.loginState.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 55.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp, end = 225.dp, bottom = 50.dp),
            text = "Log in",
            fontWeight = FontWeight.Black,
            fontSize = 35.sp,
            color = Color.Black,
        )
        Text(
            text = "Type your information",
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(9.dp),
            singleLine = true,
            placeholder = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(9.dp),
            singleLine = true,
            placeholder = { Text(text = "Password") }
        )

        Button(
            onClick = {
                scope.launch {
                    viewModel.loginUser(email, password)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 30.dp, 30.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "Login", color = Color.White, modifier = Modifier.padding(7.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            if (state.value?.isLoading == true) {
                CircularProgressIndicator()
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(horizontalArrangement = Arrangement.Center) {
                    Divider(
                        color = Color.Gray, thickness = 1.dp, modifier = Modifier
                            .weight(1f)
                            .padding(top = 9.dp)
                    )
                    Text(
                        text = "Or connect with",
                        fontSize = 13.sp,
                        modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                    Divider(
                        color = Color.Gray, thickness = 1.dp, modifier = Modifier
                            .weight(1f)
                            .padding(top = 9.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row  {
                    Icon(
                        painter = painterResource(id = R.drawable.google_1),
                        contentDescription = "black google plus icon",
                        modifier = Modifier
                            .size(52.dp)
                            .padding(end = 8.dp)
                            .clickable(
                                enabled = true,
                                onClick = {
                                    val gso = GoogleSignInOptions
                                        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                        .requestEmail()
                                        .requestIdToken(ServerClient)
                                        .build()

                                    val googleSignInClient = GoogleSignIn.getClient(context, gso)

                                    launcher.launch(googleSignInClient.signInIntent)
                                }
                            )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.github_1),
                        contentDescription = "black github icon",
                        modifier = Modifier
                            .size(46.dp)
                            .clickable(
                                enabled = true,
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse("https://languageapp-fe3d6.firebaseapp.com")
                                    )
                                    context.startActivity(intent)
                                    // In the onActivityResult() method, get the result of the authentication

                                }))
                                    }

                                }


                }
                Spacer(modifier = Modifier.height(120.dp))
                Text(
                    text = "Don't you have an account? Sign up here.",
                    modifier = Modifier.clickable(enabled = true,
                        onClick = { navController.navigate(Screens.SignUpScreen.route) })
                )
            }

            LaunchedEffect(key1 = state.value?.isSuccess) {
                scope.launch {
                    if (state.value?.isSuccess?.isNotEmpty() == true) {
                        val success = state.value?.isSuccess
                        Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
                        navController.navigate(Screens.MainScreen.route)
                    }
                }
            }
            LaunchedEffect(key1 = state.value?.isError) {
                scope.launch {
                    if (state.value?.isError?.isNotEmpty() == true) {
                        val error = state.value?.isError
                        Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
                    }
                }
            }
            LaunchedEffect(key1 = googleSignInState.isSuccess) {
                scope.launch {
                    if (googleSignInState.isSuccess?.isNotEmpty() == true) {
                        Toast.makeText(context, "You signed in with your google account", Toast.LENGTH_LONG).show()
                        navController.navigate(Screens.MainScreen.route)
                    }
                }
            }
            LaunchedEffect(key1 = googleSignInState.isError) {
                scope.launch {
                    if (googleSignInState.isError?.isNotEmpty() == true) {
                        val error = state.value?.isError
                        Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }



