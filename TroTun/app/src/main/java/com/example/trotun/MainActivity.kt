package com.example.trotun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var qrCodeResultTv: TextView
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val result = it.data?.getStringExtra(ScanQrCodeActivity.QR_CODE_VALUE)
                updateQrCodeResultTextView(result)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        qrCodeResultTv = findViewById(R.id.qr_code_result_tv)
        initButtonClickListener()


    }

    private fun initButtonClickListener() {
        val startScanButton = findViewById<Button>(R.id.start_scan_button)
        startScanButton.setOnClickListener {
            val intentQrCode = Intent(this, ScanQrCodeActivity::class.java)
            resultLauncher.launch(intentQrCode)
            val btn = findViewById<Button>(R.id.btn)
           btn.setOnClickListener {
                val intent = Intent(this,Interface::class.java)
                startActivity(intent)
            }

        }
    }
    private fun updateQrCodeResultTextView(result: String?) {
        result?.let {
            runOnUiThread {
                qrCodeResultTv.text = it
            }
        }
    }
}