package com.appexamples.firebaseauthjetpackcompose.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Brush
import com.appexamples.firebaseauthjetpackcompose.ui.theme.gradientList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.random.Random

data class Lesson (
    var lesson_name: String =" ",
    var color: Brush = gradientList[4],
    var words: List<String> = listOf()
)


@Composable
fun lessonList(): List<Lesson> {
    val lessons = remember {
        mutableStateListOf<Lesson>()
    }
    val db = Firebase.firestore.collection("lessons")
    db.get().addOnSuccessListener {
        lessons.updateList(it.toObjects(Lesson::class.java))
    }.addOnFailureListener {
        lessons.updateList(listOf())
    }
    return lessons
}



fun <T> SnapshotStateList<T>.updateList(newList: List<T>){
    clear()
    addAll(newList)
}


