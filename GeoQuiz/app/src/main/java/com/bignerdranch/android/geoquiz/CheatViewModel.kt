package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CHEATING_DETECTED_KEY = "CHEATING_DETECTED_KEY"
class CheatViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {
    public var cheatingDetected: Boolean
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: false
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

}
