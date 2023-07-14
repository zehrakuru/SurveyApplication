package com.example.surveyapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CombinedInfo(
    val personalInfo: PersonalInfo,
    val hobbies: String,
    val book: String,
    val answer: String
) : Parcelable
