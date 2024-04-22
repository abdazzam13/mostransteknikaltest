package com.example.mostransteknikaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mostransteknikaltest.R
import android.widget.Button
import android.widget.EditText


class AddLocationActivity : AppCompatActivity() {
    private lateinit var locationEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_location)

        // Inisialisasi view
        locationEditText = findViewById(R.id.edit_text_location)
        addButton = findViewById(R.id.button_add)

        // Set listener pada tombol "Tambahkan"
        addButton.setOnClickListener {
            // Panggil fungsi untuk menambahkan lokasi
            addLocation()
        }
    }

    private fun addLocation() {
        // Mendapatkan teks dari input
        val location = locationEditText.text.toString().trim()

        // Pastikan input tidak kosong
        if (location.isNotEmpty()) {
            // Lakukan aksi tambahkan lokasi di sini
            // Misalnya, simpan lokasi ke database atau kirim ke server
            // Di sini Anda dapat menambahkan logika sesuai kebutuhan aplikasi Anda
            // Untuk contoh, saya hanya akan mencetak lokasi yang ditambahkan ke logcat
            println("Lokasi ditambahkan: $location")

            // Setelah lokasi ditambahkan, Anda dapat menutup activity ini
            finish()
        } else {
            // Jika input kosong, berikan pesan kepada pengguna
            // Misalnya, menggunakan Toast atau menampilkan pesan di TextView
        }
    }
}
