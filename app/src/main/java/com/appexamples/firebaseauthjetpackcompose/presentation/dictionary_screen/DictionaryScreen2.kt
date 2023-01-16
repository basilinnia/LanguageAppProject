package com.appexamples.firebaseauthjetpackcompose.presentation.dictionary_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import com.appexamples.firebaseauthjetpackcompose.navigation.Screens
import com.appexamples.firebaseauthjetpackcompose.ui.theme.fabColor

@Composable
fun DictionaryScreen() {
    val isAdded = remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val words = remember { mutableStateListOf(Word()) }
        GetData(words = words)
        if (isAdded.value) {
            GetData(words = words)
        }
        LazyColumn {
            items(words) { item: Word ->
                WordCard(word = item)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Box(
            modifier = Modifier.height(600.dp),
            contentAlignment = BottomEnd
        ) {
            var popup by remember { mutableStateOf(false) }
            Text(text = "HEY BURAYA KOY", fontSize = 30.sp,modifier = Modifier
                .padding(top = 120.dp)
                .align(
                    Alignment.TopCenter
                ))
            Button(
                onClick = { popup = true },
                Modifier
                    .height(50.dp)
                    .width(50.dp), border = BorderStroke(1.dp, Color.Black), shape = CircleShape
            ) {
                Icon(
                    Icons.Outlined.Add,
                    contentDescription = "summation icon"
                )
            }
            if (popup) {
                Popup(
                    popupPositionProvider = WindowCenterOffsetPositionProvider(),
                    properties = PopupProperties(focusable = true),
                    onDismissRequest = { popup = false },
                ) {
                    Surface(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xCCEEEEEE),
                    ) {
                        Column(
                            modifier = Modifier.padding(100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            var word by remember { mutableStateOf( "") }
                            var germanEquivalent by remember { mutableStateOf("") }

                            OutlinedTextField(
                                value = word,
                                singleLine = true,
                                onValueChange = {
                                    word = it
                                },
                                label = { Text("Word") }
                            )
                            OutlinedTextField(
                                value = germanEquivalent,
                                singleLine = true,
                                onValueChange = {
                                    germanEquivalent = it
                                }, label = { Text("German Equivalent") }
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            TextButton(onClick = {
                                popup = false
                                isAdded.value = true
                                if (word != "" && germanEquivalent != "") {
                                    addWord(Word(word, germanEquivalent))
                                }
                            }) {
                                Text(text = "Add that Word")
                            }
                        }
                    }
                }
            }
        }

    }
}


class WindowCenterOffsetPositionProvider(
    private val x: Int = 0,
    private val y: Int = 0
) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        return IntOffset(
            (windowSize.width - popupContentSize.width) / 2 + x,
            (windowSize.height - popupContentSize.height) / 2 + y
        )
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .background(
                color = fabColor,
                shape = RoundedCornerShape(
                    topEndPercent = 0,
                    topStartPercent = 0,
                    bottomEndPercent = 20,
                    bottomStartPercent = 20
                )
            )
    )
}
