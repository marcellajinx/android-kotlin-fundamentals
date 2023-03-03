package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleTheme {
                        ComposeArticleApp()
                    }
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(title = stringResource(R.string.article_title_text),
        content1 = stringResource(R.string.article_content1_text),
        content2 = stringResource(R.string.article_content2_text),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(title: String, content1: String, content2: String, imagePainter: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = "header-img", contentScale = ContentScale.FillWidth)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        Text(
            text = content1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = content2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}