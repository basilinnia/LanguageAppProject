package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen


import ChipSection
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun LessonsScreen() {
    OnSelectedCategoryChanged()
}

@Composable
fun OnSelectedCategoryChanged() {
    val chips: List<String> = listOf("All", "Beginner", "Indermediate", "Advanced")

    var selectedChip by remember {
        mutableStateOf(0)
    }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            ChipSection(chips = chips, onSelectedCategoryChanged = {
                when (it) {
                    "All" -> selectedChip = 0
                    "Beginner" -> selectedChip = 1
                    "Indermediate" -> selectedChip = 2
                    "Advanced" -> selectedChip = 3
                }
            })

            when (selectedChip) {
                0 -> {
                    // Display list for Chip 1
                   All()
                }
                1 -> {
                    // Display list for Chip 2
                    Beginner()
                }
                2 -> {
                    // Display list for Chip 1
                    Intermediate()
                }
                3 -> {
                    // Display list for Chip 2
                    Advanced()
                }
            }
        }
}
