package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appexamples.firebaseauthjetpackcompose.R
import com.appexamples.firebaseauthjetpackcompose.presentation.activity_navigation.MainNavButtons
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bottom_color
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun HomeScreen() {
    Column {
        Header()
        Column(modifier = Modifier
            .padding(start = 30.dp, end = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            MainNavButtons()
        }
    }
}


@Composable
fun Header() {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            .size(370.dp, 170.dp)
            .background(bottom_color, RoundedCornerShape(20)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
                Row {
                    Column  {
                        Text(
                            text = "Hello, Ecem",
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(end = 90.dp, bottom = 10.dp)
                        )
                        Text(
                            text = "Let's learn something today",
                            fontStyle = FontStyle.Italic,
                            color = Color.DarkGray
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "User profile photo",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                }
            }
    }
