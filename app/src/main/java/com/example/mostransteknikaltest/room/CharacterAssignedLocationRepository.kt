package com.example.mostransteknikaltest.room

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CharacterAssignedLocationRepository(application: Application) {
    private val characterAssignedLocationDao: CharacterAssignedLocationDao

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val database = CharacterAssignedLocationRoomDatabase.getDatabase(application)
        characterAssignedLocationDao = database.characterAssignedLocationDao()
    }

    fun insert(characterWithAssignedLocation: CharacterWithAssignedLocation) {
        executorService.execute { characterAssignedLocationDao.insert(characterWithAssignedLocation) }
    }

    fun clear() = characterAssignedLocationDao.clear()

    fun getLocations(): LiveData<List<CharacterWithAssignedLocation>> = characterAssignedLocationDao.getLocations()
}