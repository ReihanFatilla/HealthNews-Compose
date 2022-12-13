package com.reift.healthnews_compose.ui.data

import android.os.Parcelable

data class News(
    val title: String,
    val author: String,
    val date: String,
    val desc: String,
    val photo: Int
)
