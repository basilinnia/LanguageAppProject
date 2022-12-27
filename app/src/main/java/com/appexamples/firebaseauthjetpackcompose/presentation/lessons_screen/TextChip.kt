import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.Advanced
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.All
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.Beginner
import com.appexamples.firebaseauthjetpackcompose.presentation.lessons_screen.Intermediate
import com.appexamples.firebaseauthjetpackcompose.ui.theme.darkBlue
import com.appexamples.firebaseauthjetpackcompose.ui.theme.lightBlue


@Composable
fun ChipSection(
    chips: List<String>,
    onSelectedCategoryChanged: (String) -> Unit
    ) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                        onSelectedCategoryChanged(chips[it])
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) lightBlue
                        else darkBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = White)
            }
        }
    }
}

