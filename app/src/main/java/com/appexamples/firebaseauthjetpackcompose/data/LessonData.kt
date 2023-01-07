package com.appexamples.firebaseauthjetpackcompose.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Lesson (
    var lesson_name: String =" ",
    var words: List<String> = listOf()
)

val db = Firebase.firestore.collection("lessons")

fun addWord(words: List<Lesson>) {
    words.forEach { word->
        db.document(word.lesson_name)
            .set(word)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }
}



@Composable
fun GetData(lessons: SnapshotStateList<Lesson>) {
    db.get().addOnSuccessListener {
        lessons.updateList(it.toObjects(Lesson::class.java))
    }.addOnFailureListener {
        lessons.updateList(listOf())
    }
}
fun <T> SnapshotStateList<T>.updateList(newList: List<T>){
    clear()
    addAll(newList)
}
