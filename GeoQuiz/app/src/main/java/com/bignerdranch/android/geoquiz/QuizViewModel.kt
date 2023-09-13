package com.bignerdranch.android.geoquiz
/*

    Written by Alex Mariano
    Dr. Dave Johannsen
    CS 4750 Mobile Application Development

 */

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_canberra, false),
        Question(R.string.question_valkyrie, true),
        Question(R.string.question_buran, false),
        Question(R.string.question_blackbird, true),
        Question(R.string.question_lagrange, true),
        Question(R.string.question_laika, true))

//    var isCheater: Boolean
//        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
//        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    public var isCheater: Boolean
        get() = questionBank[currentIndex].cheated
        set(value) {
            questionBank[currentIndex].cheated = value
        }

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev(){
        if (currentIndex == 0) {
            currentIndex = questionBank.size
        }
        currentIndex = (currentIndex - 1) % questionBank.size
    }
}