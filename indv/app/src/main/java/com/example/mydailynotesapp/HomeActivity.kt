package com.example.mydailynotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var tvWelcome: TextView
    private lateinit var btnNewNote: Button
    private lateinit var btnViewNotes: Button
    private lateinit var btnProfile: Button
    private lateinit var btnAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()
        setupWelcome()
        setupListeners()
    }

    private fun initViews() {
        tvWelcome = findViewById(R.id.tv_welcome)
        btnNewNote = findViewById(R.id.btn_new_note)
        btnViewNotes = findViewById(R.id.btn_view_notes)
        btnProfile = findViewById(R.id.btn_profile)
        btnAbout = findViewById(R.id.btn_about)
    }

    private fun setupWelcome() {
        val sharedPref = getSharedPreferences("MyDailyNotes", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")
        tvWelcome.text = "Selamat datang, $username!"
    }

    private fun setupListeners() {
        btnNewNote.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }

        btnViewNotes.setOnClickListener {
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}