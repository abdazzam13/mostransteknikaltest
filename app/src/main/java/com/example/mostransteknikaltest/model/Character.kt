package com.example.mostransteknikaltest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val imageResource: String,
    val location: String,
) : Parcelable
