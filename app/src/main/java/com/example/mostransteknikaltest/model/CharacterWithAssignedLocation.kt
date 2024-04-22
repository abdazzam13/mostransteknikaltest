package com.example.mostransteknikaltest.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(indices = [Index(value = ["name",], unique = true)])
@Parcelize
data class CharacterWithAssignedLocation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "characterId")
    val characterId: Int = 0,


    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "species")
    val species: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "imageResources")
    val imageResource: String,

    @ColumnInfo(name = "assignedLocation")
    val assignedLocation: String,
) : Parcelable
