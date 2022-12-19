package com.reift.healthnews_compose.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.reift.healthnews_compose.R
import com.reift.healthnews_compose.data.DataDummy
import com.reift.healthnews_compose.data.News
import com.reift.healthnews_compose.presentation.home.ui.theme.HealthNewsComposeTheme


@Composable
fun DetailScreen(news: News, modifier: Modifier, onBackClicked: () -> Unit) {
    Scaffold(
        topBar = { DetailTopBar(onBackClicked) },
        modifier = modifier
    ) {
        DetailContent(news)
    }
}

@Composable
fun DetailTopBar(onBackClicked: () -> Unit) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.primary_color),
        title = { Text(text = "News Detail", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = {
                onBackClicked()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back_button",
                    tint = Color.White
                )
            }
        },
        elevation = 1.dp
    )
}

@Composable
fun DetailContent(news: News) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = news.title,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = news.author,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Text(
                text = news.date,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(news.photo)
                .crossfade(true)
                .build(),
            imageLoader = ImageLoader(LocalContext.current),
            contentDescription = "news_photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = news.desc,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(28.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    HealthNewsComposeTheme {
        DetailScreen(DataDummy.listNews[0], Modifier.fillMaxSize()){

        }
    }
}