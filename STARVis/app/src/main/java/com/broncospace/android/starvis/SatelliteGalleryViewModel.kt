package com.broncospace.android.starvis

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.broncospace.android.starvis.api.PositionItem
import com.broncospace.android.starvis.spacecraft.SpacecraftApi
import com.broncospace.android.starvis.spacecraft.SpacecraftResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "SatelliteGalleryViewModel"
class SatelliteGalleryViewModel : ViewModel() {
    private val satelliteRepository = SatelliteRepository()
    private val _galleryItems: MutableStateFlow<List<PositionItem>> =
        MutableStateFlow(emptyList())
    val galleryItems: StateFlow<List<PositionItem>>
        get() = _galleryItems.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                val spacecraft = satelliteRepository.fetchSpacecraft()
                Log.d(TAG, "Spacecraft: $spacecraft")


                val items = satelliteRepository.fetchSatellites()
                Log.d(TAG, "Items received: $items")
                _galleryItems.value = items
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
}