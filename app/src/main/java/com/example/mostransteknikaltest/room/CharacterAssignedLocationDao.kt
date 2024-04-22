package com.example.mostransteknikaltest.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation

@Dao
interface CharacterAssignedLocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characterWithAssignedLocation: CharacterWithAssignedLocation)

    @Query("SELECT * from characterWithAssignedLocation ORDER BY id ASC")
    fun getLocations(): LiveData<List<CharacterWithAssignedLocation>>

    @Query("DELETE FROM characterWithAssignedLocation")
    fun clear()
}