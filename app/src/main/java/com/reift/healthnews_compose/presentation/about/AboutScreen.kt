package com.reift.healthnews_compose.presentation.about

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.reift.healthnews_compose.presentation.about.ui.theme.HealthNewsComposeTheme


@Composable
fun AboutScreen(modifier: Modifier) {
    Text(text = "Hello World!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthNewsComposeTheme {
        AboutScreen(Modifier.fillMaxSize())
    }
}