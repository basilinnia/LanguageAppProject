import androidx.compose.foundation.border
import androidx.compose.material.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.appexamples.firebaseauthjetpackcompose.presentation.main_screen.bounceClick

@Composable
fun MainNavButtons() {
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ActivityBox(icon  = Icons.Outlined.BookOnline,  title =  "Text")
            ActivityBox(icon = Icons.Outlined.Cake, title = "Cake")
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            ActivityBox(icon  = Icons.Outlined.Face,  title =  "Face")
            ActivityBox(icon = Icons.Outlined.TableChart, title = "TableChart")
            }
        }
    }


@Composable
fun ActivityBox(icon: ImageVector, title: String){
    Column(modifier = Modifier
        .padding(start = 10.dp, end = 20.dp)
        .bounceClick()
        .width(140.dp)
        .height(90.dp)
        .border(2.dp, Color.Black, shape = RoundedCornerShape(10.dp) ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Icon(imageVector = icon, contentDescription = null)
            Text(text = title)
    }
}