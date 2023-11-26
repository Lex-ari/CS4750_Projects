/*

    Author: Alex Mariano
    Dr. Dave Johannsen
    CS 4750 Mobile Application Development

 */

package com.broncospace.android.starvis.api

import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
//    @GET(
//        "services/rest/?method=flickr.interestingness.getList" +
//                "&api_key=$API_KEY" +
//                "&format=json" +
//                "&nojsoncallback=1" +
//                "&extras=url_s"
//    )
    @GET("services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): FlickrResponse

    @GET("services/rest?method=flickr.photos.search")
    suspend fun searchPhotos(@Query("text") query: String): FlickrResponse
}