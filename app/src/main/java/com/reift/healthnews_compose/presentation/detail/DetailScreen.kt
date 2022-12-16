package com.reift.healthnews_compose.presentation.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.reift.healthnews_compose.R
import com.reift.healthnews_compose.presentation.home.ui.data.DataDummy
import com.reift.healthnews_compose.presentation.home.ui.data.News
import com.reift.healthnews_compose.presentation.home.ui.theme.HealthNewsComposeTheme


@Composable
fun DetailScreen(news: News, modifier: Modifier){
    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = colorResource(id = R.color.primary_color),
            title = { Text(text = "News Detail", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back_button")
                }
            }
        )
    },
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview(){
    HealthNewsComposeTheme {
        DetailScreen(DataDummy.listNews[0] ,Modifier.fillMaxSize())
    }
}