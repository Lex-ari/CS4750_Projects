package com.broncospace.android.starvis

import com.broncospace.android.starvis.api.N2YOApi
import com.broncospace.android.starvis.api.PositionItem
import com.broncospace.android.starvis.spacecraft.SpacecraftItem
import com.broncospace.android.starvis.spacecraft.SpacecraftResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.File

class SatelliteRepository {
    private val n2yoApi: N2YOApi
    private val spacecraft: List<SpacecraftItem>
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.n2yo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        n2yoApi = retrofit.create()
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<SpacecraftResponse> = moshi.adapter(SpacecraftResponse::class.java)
        spacecraft = adapter.fromJson(File(
            "./src/main/java/com/broncospace/android/starvis/spacecraft/SpacecraftList.json")
            .readText())?.spacecraft!!
    }
    suspend fun fetchSatellites() : List<PositionItem> =
        n2yoApi.fetchSatellites().positions
    suspend fun fetchSpacecraft() : List<SpacecraftItem> =
        spacecraft
}