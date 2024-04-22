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

        // Memberikan aksi klik pada card pertama (Character List)
        val card_character_list = findViewById<CardView>(R.id.card_character_list)
        card_character_list.setOnClickListener {
//             Intent untuk berpindah ke halaman CharacterDetailActivity
            val intent = Intent(this, CharacterDetailActivity::class.java)
            startActivity(intent)
        }

        // Memberikan aksi klik pada card kedua (Character List By Location)
        val card_character_list_by_location = findViewById<CardView>(R.id.card_character_list_by_location)
        card_character_list_by_location.setOnClickListener {
            // Intent untuk berpindah ke halaman CharacterListByLocationActivity (jika ada)
            // Misalnya:
            // val intent = Intent(this, CharacterListByLocationActivity::class.java)
            // startActivity(intent)
        }
    }
}
