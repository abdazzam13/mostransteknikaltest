package com.example.mostransteknikaltest.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mostransteknikaltest.model.Character
import com.example.mostransteknikaltest.model.CharacterResponse
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation
import com.example.mostransteknikaltest.retrofit.APIConfiguration
import com.example.mostransteknikaltest.room.CharacterAssignedLocationRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterAssignedLocationViewModel (application: Application): ViewModel() {
    private val characterAssignedLocationRepository: CharacterAssignedLocationRepository =
        CharacterAssignedLocationRepository(application)

    fun insert(characterWithAssignedLocation: CharacterWithAssignedLocation) {
        characterAssignedLocationRepository.insert(characterWithAssignedLocation)
    }

    fun clear() = characterAssignedLocationRepository.clear()

    fun getLocations(): LiveData<List<CharacterWithAssignedLocation>> = characterAssignedLocationRepository.getLocations()

}