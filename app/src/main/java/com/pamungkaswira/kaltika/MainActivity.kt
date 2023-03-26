package com.pamungkaswira.kaltika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.pamungkaswira.kaltika.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barisanButton.setOnClickListener { hitungBarisanAritmatika() }
        binding.deretButton.setOnClickListener { hitungDeretAritmatika() }
        binding.resetButton.setOnClickListener { reset() }
    }

    private fun hitungBarisanAritmatika() {
        val sukuAwal = binding.sukuAwalInput.text.toString()
        val beda = binding.bedaInput.text.toString()
        val sukuN = binding.sukuNInput.text.toString()

        if (TextUtils.isEmpty(sukuAwal)) {
            Toast.makeText(this, R.string.sukuAwalInvalid, Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(beda)) {
            Toast.makeText(this, R.string.bedaInvalid, Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(sukuN)) {
            Toast.makeText(this, R.string.sukuNInvalid, Toast.LENGTH_LONG).show()
            return
        }

        val barisanAritmatika = sukuAwal.toFloat() + (sukuN.toFloat() - 1) * beda.toFloat()

        binding.hasilTextView.text = getString(R.string.barisanAritmatika, barisanAritmatika)
    }

    private fun hitungDeretAritmatika() {
        val sukuAwal = binding.sukuAwalInput.text.toString()
        val beda = binding.bedaInput.text.toString()
        val sukuN = binding.sukuNInput.text.toString()

        if (TextUtils.isEmpty(sukuAwal)) {
            Toast.makeText(this, R.string.sukuAwalInvalid, Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(beda)) {
            Toast.makeText(this, R.string.bedaInvalid, Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(sukuN)) {
            Toast.makeText(this, R.string.sukuNInvalid, Toast.LENGTH_LONG).show()
            return
        }

        val deretAritmatika = sukuN.toFloat() / 2 * (2 * sukuAwal.toFloat() + (sukuN.toFloat() - 1) * beda.toFloat())

        binding.hasilTextView.text = getString(R.string.deretAritmatika, deretAritmatika)
    }

    private fun reset() {
        val sukuAwal = binding.sukuAwalInput.text.toString()
        val beda = binding.bedaInput.text.toString()
        val sukuN = binding.sukuNInput.text.toString()

        if (TextUtils.isEmpty(sukuAwal) && TextUtils.isEmpty(beda) && TextUtils.isEmpty(sukuN)) {
            Toast.makeText(this, R.string.resetInvalid, Toast.LENGTH_LONG).show()
            return
        }

        binding.sukuAwalInput.text?.clear()
        binding.bedaInput.text?.clear()
        binding.sukuNInput.text?.clear()
        binding.hasilTextView.text = ""
    }
}