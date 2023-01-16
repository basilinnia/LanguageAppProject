package com.appexamples.firebaseauthjetpackcompose.presentation.dictionary_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.android.animation.SegmentType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DictionaryScreen2() {
    Header()
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Dictionary")
            Text(text = "HEY BURAYA KOY", fontSize = 30.sp,modifier = Modifier
                .padding(top = 120.dp)
                .align(
                    TopCenter
                ))
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFF023A5F),
                shape = RoundedCornerShape(
                    topEndPercent = 0,
                    topStartPercent = 0,
                    bottomEndPercent = 20,
                    bottomStartPercent = 20
                )
            )
    )
}

