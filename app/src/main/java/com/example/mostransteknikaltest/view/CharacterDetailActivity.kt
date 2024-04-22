package com.example.mostransteknikaltest.view

import CharacterAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.databinding.ActivityCharacterDetailBinding
import com.example.mostransteknikaltest.model.Character
import com.example.mostransteknikaltest.viewmodel.CharacterViewModel
import com.example.mostransteknikaltest.viewmodel.viewmodelfactory.ViewModelFactory

class CharacterDetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityCharacterDetailBinding
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var characterViewModel: CharacterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        characterAdapter = CharacterAdapter()
        characterViewModel = getCharacterViewModel(this)
        characterViewModel.getCharacter()
        characterViewModel.getCharacters().observe(this){
            character -> characterAdapter.setCharacterData(character)
        }

//        val characters = arrayListOf<Character>(
//            Character("Character 1", "Human", "Male", ""),
//            Character("Character 2", "Alien", "Female", ""),
//            Character("Character 3", "Robot", "Unknown", "")
//        )
//
//        characterAdapter.setCharacterData(characters)
        bind.recyclerViewCharacterDetail.layoutManager = LinearLayoutManager(this)
        bind.recyclerViewCharacterDetail.adapter = characterAdapter
    }

    private fun getCharacterViewModel(activity: AppCompatActivity): CharacterViewModel {
        val characterViewModelFactory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(
            activity,
            characterViewModelFactory
        ).get(CharacterViewModel::class.java)
    }
}
