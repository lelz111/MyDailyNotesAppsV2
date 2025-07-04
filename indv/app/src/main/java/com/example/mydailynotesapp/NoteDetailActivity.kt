package com.example.mydailynotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvContent: TextView
    private lateinit var tvDate: TextView
    private lateinit var btnEdit: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        initViews()
        displayNoteDetail()
        setupListeners()
    }

    private fun initViews() {
        tvTitle = findViewById(R.id.tv_title)
        tvContent = findViewById(R.id.tv_content)
        tvDate = findViewById(R.id.tv_date)
        btnEdit = findViewById(R.id.btn_edit)
        btnBack = findViewById(R.id.btn_back)
    }

    private fun displayNoteDetail() {
        val noteTitle = intent.getStringExtra("note_title") ?: "Judul Tidak Ditemukan"
        val notePosition = intent.getIntExtra("note_position", 0)

        tvTitle.text = noteTitle
        tvDate.text = "Dibuat: ${getDummyDate(notePosition)}"
        tvContent.text = getDummyContent(notePosition)
    }

    private fun getDummyDate(position: Int): String {
        val dates = arrayOf(
            "1 Januari 2024",
            "5 Januari 2024",
            "10 Januari 2024",
            "15 Januari 2024",
            "20 Januari 2024"
        )
        return dates[position]
    }

    private fun getDummyContent(position: Int): String {
        val contents = arrayOf(
            "Ini adalah catatan pertama saya di aplikasi MyDailyNotes. Hari ini saya belajar membuat aplikasi Android dengan Kotlin.",
            "Perjalanan ke Bandung sangat menyenangkan. Cuaca di sana sejuk dan pemandangannya indah. Saya mengunjungi beberapa tempat wisata.",
            "Rencana liburan bulan depan:\n- Mengunjungi Yogyakarta\n- Berwisata kuliner\n- Mengunjungi Candi Borobudur\n- Belanja oleh-oleh",
            "Meeting dengan tim berjalan lancar. Kami membahas progress proyek dan timeline yang akan datang. Semua anggota tim berkomitmen untuk menyelesaikan tugas tepat waktu.",
            "Ide proyek baru untuk aplikasi mobile:\n- Aplikasi manajemen keuangan\n- Fitur tracking pengeluaran\n- Laporan bulanan\n- Integrasi dengan bank"
        )
        return contents[position]
    }

    private fun setupListeners() {
        btnEdit.setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            intent.putExtra("note_title", tvTitle.text.toString())
            intent.putExtra("note_content", tvContent.text.toString())
            intent.putExtra("note_position", this.intent.getIntExtra("note_position", 0))
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}