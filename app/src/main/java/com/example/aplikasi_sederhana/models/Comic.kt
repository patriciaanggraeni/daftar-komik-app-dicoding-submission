package com.example.aplikasi_sederhana.models

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val image: Bitmap,
    val title: String,
    val genre: List<String>,
    val rating: Float,
    var like: Boolean = false,
    val description: Int
): Parcelable