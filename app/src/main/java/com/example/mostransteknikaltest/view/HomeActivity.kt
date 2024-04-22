package com.example.mostransteknikaltest.view;
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.mostransteknikaltest.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //change appbar text
        supportActionBar?.title = "Home"

        val card_character_list = findViewById<CardView>(R.id.card_character_list)
        card_character_list.setOnClickListener {
            val intent = Intent(this, CharacterListActivity::class.java)
            startActivity(intent)
        }

        val card_character_list_by_location = findViewById<CardView>(R.id.card_character_list_by_location)
        card_character_list_by_location.setOnClickListener {
             val intent = Intent(this, LocationListActivity::class.java)
             startActivity(intent)
        }
    }
}
