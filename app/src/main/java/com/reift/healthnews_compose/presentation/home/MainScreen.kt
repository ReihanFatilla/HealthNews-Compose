package com.reift.healthnews_compose.presentation.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import coil.compose.AsyncImage
import com.reift.healthnews_compose.R
import com.reift.healthnews_compose.constant.Extra
import com.reift.healthnews_compose.data.DataDummy
import com.reift.healthnews_compose.data.News
import com.reift.healthnews_compose.presentation.about.AboutActivity
import com.reift.healthnews_compose.presentation.detail.DetailActivity
import com.reift.healthnews_compose.presentation.home.ui.theme.HealthNewsComposeTheme


@Composable
fun MainScreen(modifier: Modifier, context: Context) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = colorResource(id = R.color.primary_color),
                title = { Text(text = "Health News", color = Color.White) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { context.startActivity(Intent(context, AboutActivity::class.java)) },
                backgroundColor = colorResource(id = R.color.primary_color)
            ) {
                Icon(Icons.Filled.Person, "about_page", tint = Color.White)
            }
        }

    ) {
        LazyColumn(
            contentPadding = PaddingValues(28.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(DataDummy.listNews) { news ->
                RowItemNews(news = news) {
                    context.startActivity(
                        Intent(context, DetailActivity::class.java)
                            .putExtra(Extra.NEWS_DETAIL, news)
                    )
                }
            }
        }
    }
}

@Composable
fun RowItemNews(news: News, onNewsClicked: (News) -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color.White,
        elevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable(true, onClick = {
                onNewsClicked(news)
            })
    ) {
        ItemNewsContent(news = news)
    }
}

@Composable
fun ItemNewsContent(news: News) {
    Row {
        AsyncImage(
            model = news.photo,
            contentDescription = "${news.title} Image",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                ),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = news.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = news.author,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                color = colorResource(id = R.color.primary_color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HealthNewsAppPreview() {
    HealthNewsComposeTheme {
        MainScreen(Modifier.fillMaxSize(), LocalContext.current)
    }
}