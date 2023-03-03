package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun QuadrantCard(title: String, text: String, bgColor: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(bgColor).fillMaxSize().padding(all = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
           QuadrantCard(
               title = stringResource(R.string.green_title),
               text = stringResource(id = R.string.green_text),
               bgColor = androidx.compose.ui.graphics.Color.Green,
               modifier = Modifier.weight(1f)
           )

            QuadrantCard(
                title = stringResource(R.string.yellow_title),
                text = stringResource(id = R.string.yellow_text),
                bgColor = androidx.compose.ui.graphics.Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(R.string.blue_title),
                text = stringResource(id = R.string.blue_text),
                bgColor = androidx.compose.ui.graphics.Color.Cyan,
                modifier = Modifier.weight(1f)
            )

            QuadrantCard(
                title = stringResource(R.string.grey_title),
                text = stringResource(id = R.string.grey_text),
                bgColor = androidx.compose.ui.graphics.Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}