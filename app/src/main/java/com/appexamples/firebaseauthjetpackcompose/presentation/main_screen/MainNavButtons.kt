import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.unit.dp

@Composable
fun MainNavButtons() {
    var button1 by remember {
        mutableStateOf(false)
    }
    var button2 by remember {
        mutableStateOf(false)
    }
    var button3 by remember {
        mutableStateOf(false)
    }
    var button4 by remember {
        mutableStateOf(false)
    }

    val Home = Icons.Outlined.Home
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(start = 20.dp,end = 40.dp)
                .clickable(onClick = { button1 = !button1 })
                .size(120.dp)
                .border(2.dp, Color.Black)) {
                Icon(
                    imageVector = Home,
                    contentDescription = "",
                    tint = if (button1) Color.Green else Color.Black
                )
            }
            Box(modifier = Modifier
                .clickable(onClick = { button2 = !button2 })
                .size(120.dp)
                .border(2.dp, Color.Black)) {
                Icon(
                    imageVector = Home,
                    contentDescription = "",
                    tint = if (button2) Color.Green else Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(start = 20.dp,end = 40.dp)
                .clickable(onClick = { button3 = !button3 })
                .size(120.dp)
                .border(2.dp, Color.Black)) {
                Icon(
                    imageVector = Home,
                    contentDescription = "",
                    tint = if (button3) Color.Green else Color.Black
                )
            }
            Box(modifier = Modifier
                .clickable(onClick = { button4 = !button4 })
                .size(120.dp)
                .border(2.dp, Color.Black)) {
                Icon(
                    imageVector = Home,
                    contentDescription = "",
                    tint = if (button4) Color.Green else Color.Black
                )
            }
        }
    }
}
