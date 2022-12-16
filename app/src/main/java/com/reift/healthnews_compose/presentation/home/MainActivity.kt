package com.reift.healthnews_compose.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.reift.healthnews_compose.constant.Extra
import com.reift.healthnews_compose.presentation.detail.DetailActivity
import com.reift.healthnews_compose.presentation.home.ui.theme.HealthNewsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthNewsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(modifier = Modifier.fillMaxSize(), this)
                }
            }
        }
    }
}