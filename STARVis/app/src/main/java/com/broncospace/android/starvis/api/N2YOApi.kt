/*

    Author: Alex Mariano
    Dr. Dave Johannsen
    CS 4750 Mobile Application Development

 */

package com.broncospace.android.starvis.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "89PAUZ-9G5ZB6-49ZGHR-55XX"
private const val satelliteId = 25544
interface N2YOApi {
    @GET(
        "rest/v1/satellite/positions" +
                "/$satelliteId" +
                "/" + "34.052571" + //Latitude
                "/" + "-118.243907" + //Longitude
                "/" + "0" + //Altitude
                "/" + "2" + //Seconds Future
                "&apiKey=$API_KEY"
    )
    suspend fun fetchSatellites(): N2YOResponse
}