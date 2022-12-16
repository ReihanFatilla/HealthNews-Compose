package com.reift.healthnews_compose.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val author: String,
    val date: String,
    val desc: String,
    val photo: String
): Parcelable
