package com.example.quanlycongviec

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tenCongViec = intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        val moTa = intent.getStringExtra("MO_TA") ?: ""
        findViewById<TextView>(R.id.tvTenCongViec).text = tenCongViec
        findViewById<TextView>(R.id.tvMoTa).text = moTa
    }
    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTa: TextView
    private val boChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == RESULT_OK) {
            val duLieu = ketQua.data
            tvTenCongViec.text = duLieu?.getStringExtra("TEN_MOI") ?: ""
            tvMoTa.text = duLieu?.getStringExtra("MO_TA_MOI") ?: ""
        }
    }
}