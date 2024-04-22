package com.example.mostransteknikaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.viewmodel.CharacterViewModel
import com.example.mostransteknikaltest.viewmodel.viewmodelfactory.ViewModelFactory
import CharacterAdapter
import android.content.Intent
import com.example.mostransteknikaltest.databinding.ActivityCharacterListBinding

class CharacterListActivity : AppCompatActivity() {
    private lateinit var bind: ActivityCharacterListBinding
    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var characterViewModel: CharacterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //change appbar text
        supportActionBar?.title = "Character List"

        //adapter
        characterAdapter = CharacterAdapter()
        bind.recyclerViewCharacterList.layoutManager = LinearLayoutManager(this)
        bind.recyclerViewCharacterList.adapter = characterAdapter

        //viewmodel
        characterViewModel = getCharacterViewModel(this)
        characterViewModel.getCharacter()
        characterViewModel.getCharacters().observe(this){
                character -> if (character != null){
            characterAdapter.setCharacterData(character)
            bind.recyclerViewCharacterList.setOnClickListener {
                print("CharacterId" + bind.recyclerViewCharacterList.id)
                val intent = Intent(this, CharacterDetailActivity::class.java)
                startActivity(intent)
            }
        }

        }


    }

    private fun getCharacterViewModel(activity: AppCompatActivity): CharacterViewModel {
        val characterViewModelFactory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(
            activity,
            characterViewModelFactory
        ).get(CharacterViewModel::class.java)
    }
}