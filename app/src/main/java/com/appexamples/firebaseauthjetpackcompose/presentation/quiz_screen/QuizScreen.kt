package com.appexamples.firebaseauthjetpackcompose.presentation.quiz_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.ui.theme.bg_color
import com.appexamples.firebaseauthjetpackcompose.ui.theme.fabColor

@Composable
fun Result () {
    Column(modifier = Modifier
        .size(300.dp)
        .background(color = Color.White)) {
        Text(text = "QUIZ OVER")
    }
}


@Composable
fun QuizScreen(questionList: List<Question>, navController: NavHostController) {
    questionList!!.shuffled()

    val questionAnswered = remember { mutableStateOf(false) }
    val isComplete = remember { mutableStateOf(false) }
    val questionIndex = remember { mutableStateOf(0) }
    val selectedOption = remember { mutableStateOf<Int?>(null) }
    val optionColorList = remember { mutableStateListOf(Color.Transparent,Color.Transparent,Color.Transparent,Color.Transparent) }

    val animatedProgress by animateFloatAsState(
        targetValue =
        (questionIndex.value + 1) / questionList.size.toFloat(),
        animationSpec =
        ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    fun checkOption(selectedOption: Int?) {
        if (selectedOption == questionList[questionIndex.value].correctAnswer) {
            // Change the selected option's color to green
            optionColorList[selectedOption] = Color.Green

        } else {
            // Change the selected option's color to red
            optionColorList[selectedOption!!] = Color.Red
        }
    }

    Column(modifier= Modifier.fillMaxSize().background(bg_color),horizontalAlignment = Alignment.CenterHorizontally) {

            IconButton(
                onClick = {navController.navigate(Screens.MainScreen.route)},
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 40.dp)
            ) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "Finish",
                )
            }
            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

        Text(text = questionList[questionIndex.value].question)

            questionList[questionIndex.value].optionList.forEachIndexed {index, it ->
                Button(
                    modifier = Modifier.size(300.dp, 40.dp).border(3.dp, optionColorList[index]),
                    onClick = {
                        if (!questionAnswered.value) {
                            selectedOption.value = index
                            questionAnswered.value = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (selectedOption.value == index) Color.Gray else Color.Transparent)
                ) {
                    Text(it)
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            Button(
                enabled = questionAnswered.value,
                onClick = { checkOption(selectedOption.value) },
                colors = ButtonDefaults.buttonColors(backgroundColor = fabColor)
            ) {
                Text(text = "CHECK")
            }

            Button(
                onClick = {
                    if (questionList.size-1  > questionIndex.value ) {
                        selectedOption.value = null
                        for (i in 0 until optionColorList.size) {
                            optionColorList[i] = Color.Transparent
                        }
                        questionAnswered.value = false
                        questionIndex.value += 1
                    } else {
                        isComplete.value = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = fabColor)
            ) {
                Text(text = "NEXT")
            }

            if (isComplete.value) {
                Result()
            }
    }
}





