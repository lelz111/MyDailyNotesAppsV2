package com.example.mydailynotesapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    private lateinit var tvAppName: TextView
    private lateinit var tvVersion: TextView
    private lateinit var tvDeveloper: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        initViews()
        setupContent()
        setupListeners()
    }

    private fun initViews() {
        tvAppName = findViewById(R.id.tv_app_name)
        tvVersion = findViewById(R.id.tv_version)
        tvDeveloper = findViewById(R.id.tv_developer)
        tvDescription = findViewById(R.id.tv_description)
        btnBack = findViewById(R.id.btn_back)
    }

    private fun setupContent() {
        tvAppName.text = "MyDailyNotes"
        tvVersion.text = "Versi 1.0.0"
        tvDeveloper.text = "Dikembangkan oleh Tim 1"
        tvDescription.text = "MyDailyNotes adalah aplikasi catatan harian yang membantu Anda mencatat dan mengelola catatan penting sehari-hari. Aplikasi ini dibuat dengan menggunakan Kotlin dan Android Studio.\n\nFitur utama:\n• Buat catatan baru\n• Lihat daftar catatan\n• Edit catatan\n• Manajemen profil\n\n© 2024 MyDailyNotes. All rights reserved."
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }
}