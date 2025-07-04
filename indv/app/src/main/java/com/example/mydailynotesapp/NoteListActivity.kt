package com.example.mydailynotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NoteListActivity : AppCompatActivity() {
    private lateinit var lvNotes: ListView
    private lateinit var btnBack: Button
    private lateinit var noteAdapter: ArrayAdapter<String>

    // Dummy data
    private val dummyNotes = arrayListOf(
        "Catatan Hari Pertama",
        "Perjalanan ke Bandung",
        "Rencana Liburan",
        "Meeting dengan Tim",
        "Ide Proyek Baru"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        initViews()
        setupListView()
        setupListeners()
    }

    private fun initViews() {
        lvNotes = findViewById(R.id.lv_notes)
        btnBack = findViewById(R.id.btn_back)
    }

    private fun setupListView() {
        noteAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dummyNotes)
        lvNotes.adapter = noteAdapter

        lvNotes.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, NoteDetailActivity::class.java)
            intent.putExtra("note_title", dummyNotes[position])
            intent.putExtra("note_position", position)
            startActivity(intent)
        }
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }
}