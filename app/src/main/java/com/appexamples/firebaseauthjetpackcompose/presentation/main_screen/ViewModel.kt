package com.appexamples.firebaseauthjetpackcompose.presentation.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.Lesson
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {
    private val _lessons = MutableLiveData<List<Lesson>>()
    val lessons: LiveData<List<Lesson>> = _lessons

    init {
        val db = Firebase.firestore.collection("lessons")
        db.addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                _lessons.value = emptyList()
                return@addSnapshotListener
            }
            val lessons = snapshot?.toObjects(Lesson::class.java)
            _lessons.value = lessons
        }
    }
}
