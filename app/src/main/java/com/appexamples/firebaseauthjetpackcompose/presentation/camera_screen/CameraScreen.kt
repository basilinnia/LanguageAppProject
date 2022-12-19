package com.appexamples.firebaseauthjetpackcompose.presentation.camera_screen

import android.graphics.Point
import android.util.Size
import androidx.camera.core.ImageAnalysis
import androidx.compose.runtime.Composable
import com.google.mlkit.common.model.LocalModel
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.custom.CustomObjectDetectorOptions

@Composable
fun CameraScreen() {

    CameraPreview()
}
