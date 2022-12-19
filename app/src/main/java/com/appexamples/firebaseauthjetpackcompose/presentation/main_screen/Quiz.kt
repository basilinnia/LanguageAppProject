package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GermanQuiz(germanWord: String) {
    // Replace with correct answer for the given German word
    val correctAnswer = "correct answer"
    val answers = listOf("answer 1", "answer 2", "answer 3", correctAnswer)
    var answerCorrect by remember {
        mutableStateOf(false)
    }

    Column() {
        TopAppBar(title = { Text("German Quiz") })

        // Show the German word
        Text(germanWord)

        // Use a row to display the answer choices horizontally
        Column(modifier = Modifier.fillMaxWidth()) {
            // Use the .forEach method to iterate through the answers list and create a button for each answer
            answers.forEach { answer ->
                Spacer(modifier = Modifier.height(6.dp))
                // Use the enabled property of the Button to make the buttons unclickable when the results are shown
                Button(
                    modifier = Modifier.width(400.dp),
                    onClick = {answerCorrect = true},
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (answerCorrect) Color.Green else Color.Red)
                ) {
                    Text(answer)
                }
            }
        }
    }
}
