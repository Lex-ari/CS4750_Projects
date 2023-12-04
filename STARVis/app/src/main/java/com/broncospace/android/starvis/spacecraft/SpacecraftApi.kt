package com.broncospace.android.starvis.spacecraft

import com.broncospace.android.starvis.api.N2YOResponse
import retrofit2.http.GET

interface SpacecraftApi {
    @GET
    suspend fun fetchSpacecraft(): SpacecraftResponse
}