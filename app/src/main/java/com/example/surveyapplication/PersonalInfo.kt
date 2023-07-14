package com.example.surveyapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonalInfo(
    val nameSurname: String,
    val email: String,
    val phone: String,
    val age: Int,
    val city: String
) : Parcelable