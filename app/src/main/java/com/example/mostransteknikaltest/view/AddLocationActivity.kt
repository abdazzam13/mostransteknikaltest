package com.example.mostransteknikaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mostransteknikaltest.R
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mostransteknikaltest.databinding.ActivityAddLocationBinding
import com.example.mostransteknikaltest.model.CharacterWithAssignedLocation
import com.example.mostransteknikaltest.viewmodel.CharacterAssignedLocationViewModel
import com.example.mostransteknikaltest.viewmodel.viewmodelfactory.ViewModelFactory
import com.example.mostransteknikaltest.model.Character
class AddLocationActivity : AppCompatActivity() {
    private lateinit var bind: ActivityAddLocationBinding
    private lateinit var characterAssignedLocationViewModel: CharacterAssignedLocationViewModel
    lateinit var character: Character
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAddLocationBinding.inflate(layoutInflater)
        setContentView(bind.root)

        characterAssignedLocationViewModel = getCharacterViewModel(this)
        character = intent.getParcelableExtra("character")!!
        Log.d("IDCCCCC", "IDC EXTRA: ${character}")
        bind.buttonAdd.setOnClickListener {
            addLocation()
        }
    }

    private fun addLocation() {
        val location = bind.editTextLocation.text.toString().trim()
        if (location.isNotEmpty()) {
            println("Lokasi ditambahkan: $location")
            Log.d("LOCATION", location)
            characterAssignedLocationViewModel.insert(CharacterWithAssignedLocation(characterId = character.id!!, name = character.name!!, species = character.species!!, gender = character.gender!!, imageResource = character.imageResource!!, assignedLocation = location))
            finish()
        } else {
            Toast.makeText(this, "Location harus diisi, tidak boleh kosong!", Toast.LENGTH_SHORT).show()
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
