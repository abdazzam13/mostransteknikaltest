package com.example.mostransteknikaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.databinding.ActivityAddLocationBinding
import com.example.mostransteknikaltest.databinding.ActivityLocationListBinding
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation
import com.example.mostransteknikaltest.view.adapter.LocationAdapter
import com.example.mostransteknikaltest.viewmodel.CharacterAssignedLocationViewModel
import com.example.mostransteknikaltest.viewmodel.viewmodelfactory.ViewModelFactory

class LocationListActivity : AppCompatActivity() {
    private lateinit var bind: ActivityLocationListBinding
    private lateinit var characterAssignedLocationViewModel: CharacterAssignedLocationViewModel
    lateinit var characterWithAssignedLocation: CharacterWithAssignedLocation
    private lateinit var locationAdapter: LocationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLocationListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        locationAdapter = LocationAdapter()
        bind.locationRecyclerView.layoutManager = LinearLayoutManager(this)
        bind.locationRecyclerView.adapter = locationAdapter

        characterAssignedLocationViewModel = getCharacterViewModel(this)
        characterAssignedLocationViewModel.getLocations().observe(this){
            character -> locationAdapter.submitList(character)
        }
    }

    private fun getCharacterViewModel(activity: AppCompatActivity): CharacterAssignedLocationViewModel {
        val characterViewModelFactory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(
            activity,
            characterViewModelFactory
        ).get(CharacterAssignedLocationViewModel::class.java)
    }
}