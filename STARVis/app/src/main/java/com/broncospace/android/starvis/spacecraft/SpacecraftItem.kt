package com.broncospace.android.starvis.spacecraft

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpacecraftItem(
    val id: Integer,
    val photo: String,
)