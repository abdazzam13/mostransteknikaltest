package com.example.mostransteknikaltest.view
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mostransteknikaltest.R
import com.example.mostransteknikaltest.databinding.ActivityCharacterDetailBinding
import com.example.mostransteknikaltest.model.Character
import com.example.mostransteknikaltest.viewmodel.CharacterViewModel
import com.example.mostransteknikaltest.viewmodel.viewmodelfactory.ViewModelFactory

class CharacterDetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityCharacterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //change appbar text
        supportActionBar?.title = "Character Detail"

        //set detail character
        var character: Character = intent.getParcelableExtra("character")!!
        Log.d("IDCCCCC", "IDC EXTRA: ${character}")
        Glide.with(this)
            .load(character.imageResource)
            .into(bind.imageCharacter);
        bind.textName.text = character.name
        bind.textLocation.text = character.location ?: "Null"
        bind.textSpecies.text = "${character.species} | ${character.gender}"

        bind.addLocation.setOnClickListener {
            val intent = Intent(this, AddLocationActivity::class.java).putExtra("character", character)
            startActivity(intent)
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
