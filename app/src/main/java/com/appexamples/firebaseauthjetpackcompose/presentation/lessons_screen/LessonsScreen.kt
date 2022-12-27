package com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen


import ChipSection
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.google.android.material.chip.Chip


@Composable
fun LessonsScreen() {
    onSelectedCategoryChanged()
}

@Composable
fun onSelectedCategoryChanged() {
    val chips: List<String> = listOf("All", "Beginner", "Indermediate", "Advanced")

    var selectedChip by remember {
        mutableStateOf(0)
    }

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
