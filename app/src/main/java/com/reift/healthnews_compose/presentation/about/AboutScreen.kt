package com.reift.healthnews_compose.presentation.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.reift.healthnews_compose.presentation.about.ui.theme.HealthNewsComposeTheme


@Composable
fun AboutScreen(modifier: Modifier, onBackClicked: () -> Unit) {
    Scaffold(
        topBar = { AboutTopBar(onBackClicked) },
        modifier = modifier
    ) {
        AboutContent(Modifier.fillMaxSize())
    }
}

@Composable
fun AboutTopBar(onBackClicked: () -> Unit) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.primary_color),
        title = { Text(text = "About Me", color = Color.White) },
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
fun AboutContent(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://media.licdn.com/dms/image/D5603AQGZIju6ximk2w/profile-displayphoto-shrink_800_800/0/1670913065628?e=1676505600&v=beta&t=auh6hccO-LBxAX07Ym-OFvHQJUQ75xuq26MnJzrNuxs")
                .crossfade(true)
                .build(),
            imageLoader = ImageLoader(LocalContext.current),
            contentDescription = "my_photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Reihan Fatilla",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Text(
            text = "reihanfatilla@gmail.com",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthNewsComposeTheme {
        AboutScreen(Modifier.fillMaxSize()) {}
    }
}