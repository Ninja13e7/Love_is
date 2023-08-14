package com.example.mylove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.mylove.model.Love
import com.example.mylove.model.LoveSourse


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   loveApp()
                }
            }
        }
    }
}


@Composable
fun loveApp() {
    LoveList(
        lovelist = LoveSourse().LoveRepository()
    )
}


@Composable
    fun LoveList(lovelist: List<Love>, modifier: Modifier = Modifier) {
        LazyColumn {
            items(lovelist) { love ->
                loveCard(love = love,
                    modifier =Modifier
                )
            }
        }
    }


@Composable
fun loveCard(love: Love, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.primary
    )
    Spacer(modifier.padding(8.dp))
    Card(modifier = Modifier
        .padding(12.dp)
        .clip(MaterialTheme.shapes.medium)
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )
        .background(color = color)
        ) {
        Column(modifier = modifier
            .animateContentSize (
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
                    )

        ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier
                .weight(1f)

            ) {
                Text(
                    text = LocalContext.current.getString(love.data),
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }


            loveButton(
                expanded = expanded,
                onClick = { expanded = !expanded }
            )
        }

        if (expanded) {
            informationLove(
                love = love
               )
            }
        }
    }
}
@Composable
fun loveButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
   IconButton(
       onClick = onClick,
       modifier = modifier
   ) {
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
   }
}

@Composable
fun informationLove(love: Love, modifier: Modifier = Modifier.padding(16.dp)) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
    Column(modifier = modifier
        .padding(16.dp)
        .weight(1f)) {
        Text(
            text = LocalContext.current.getString(love.itLove),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Black,
            modifier = Modifier
        )
        Text(
            text = LocalContext.current.getString(love.descriptionLove),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify
        )}

        Box(modifier = Modifier
            .size(90.dp)
            .clip(MaterialTheme.shapes.extraLarge)
        ) {
            Image(
                painter = painterResource(love.imageLove),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraLarge),
                contentScale = ContentScale.FillWidth
            )
        }
        Spacer(modifier.padding(start = 1.dp))

    }
}


@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    val love = Love(
        R.string.day1,
        R.string.love_All,
        R.string.description1,
        R.drawable.love1

    )
    AppTheme {
        loveApp()
    }
}