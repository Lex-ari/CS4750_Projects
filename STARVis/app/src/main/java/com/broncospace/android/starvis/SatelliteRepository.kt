package com.broncospace.android.starvis

import com.broncospace.android.starvis.api.N2YOApi
import com.broncospace.android.starvis.api.PositionItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class SatelliteRepository {
    private val n2yoApi: N2YOApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.n2yo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        n2yoApi = retrofit.create()
    }

    suspend fun fetchSatellites() : List<PositionItem> =
        n2yoApi.fetchSatellites().positions
}