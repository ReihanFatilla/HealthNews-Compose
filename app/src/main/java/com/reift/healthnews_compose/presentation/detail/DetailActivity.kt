package com.reift.healthnews_compose.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.reift.healthnews_compose.constant.Extra
import com.reift.healthnews_compose.data.DataDummy
import com.reift.healthnews_compose.data.News
import com.reift.healthnews_compose.presentation.detail.ui.theme.HealthNewsComposeTheme

class DetailActivity : ComponentActivity() {

    private lateinit var news: News

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        news = intent.getParcelableExtra<News>(Extra.NEWS_DETAIL) ?: DataDummy.listNews[0]

        setContent {
            HealthNewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DetailScreen(news ,Modifier.fillMaxSize()){
                        finish()
                    }
                }
            }
        }
    }
}