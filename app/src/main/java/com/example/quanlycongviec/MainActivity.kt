package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTenCongViec = findViewById<EditText>(R.id.edtTenCongViec)
        val edtMoTa = findViewById<EditText>(R.id.edtMoTa)
        val btnTaoCongViec = findViewById<Button>(R.id.btnTaoCongViec)

        btnTaoCongViec.setOnClickListener {
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("TEN_CONG_VIEC", edtTenCongViec.text.toString())
            intent.putExtra("MO_TA", edtMoTa.text.toString())
            startActivity(intent)
        }
    }
}