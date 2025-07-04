package com.example.mydailynotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvJoinDate: TextView
    private lateinit var btnLogout: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initViews()
        loadProfile()
        setupListeners()
    }

    private fun initViews() {
        tvUsername = findViewById(R.id.tv_username)
        tvEmail = findViewById(R.id.tv_email)
        tvJoinDate = findViewById(R.id.tv_join_date)
        btnLogout = findViewById(R.id.btn_logout)
        btnBack = findViewById(R.id.btn_back)
    }

    private fun loadProfile() {
        val sharedPref = getSharedPreferences("MyDailyNotes", MODE_PRIVATE)
        val username = sharedPref.getString("username", "User")

        tvUsername.text = username
        tvEmail.text = "$username@example.com"
        tvJoinDate.text = "Bergabung: 1 Januari 2024"
    }

    private fun setupListeners() {
        btnLogout.setOnClickListener {
            // Clear shared preferences
            val sharedPref = getSharedPreferences("MyDailyNotes", MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // Kembali ke login
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}