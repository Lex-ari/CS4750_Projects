package com.broncospace.android.starvis.spacecraft

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class SpacecraftResponse(
    val spacecraft: List<SpacecraftItem>
)