package com.appexamples.firebaseauthjetpackcompose.presentation.quiz_screen

import com.appexamples.firebaseauthjetpackcompose.R

object Constants{

    fun getQuestions(): ArrayList<Question>{

        val questionsList = ArrayList<Question>()
        val que1 = Question(
            "Which of the following is the capital of France?",
            listOf("Paris", "London", "Madrid", "Rome"),
            0)
        questionsList.add(que1)



        val que2 = Question(
            "Which of the following is not a type of mammal?",
            listOf("Elephant", "Kangaroo", "Crocodile", "Whale"),
            2
        )
        questionsList.add(que2)


        val que3 = Question(
            "Which of the following is the longest river in Africa?",
            listOf("Nile", "Congo", "Zambezi", "Niger"),
            0
        )

        questionsList.add(que2)


        return questionsList
    }
}