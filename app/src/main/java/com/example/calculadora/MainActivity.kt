package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Eventos de los botones
        binding.btnBisiesto.setOnClickListener {
            val intent = Intent(this, BisiestoActivity::class.java)
            startActivity(intent)
        }

        binding.btnTemperatura.setOnClickListener {
            val intent = Intent(this, TemperaturaActivity::class.java)
            startActivity(intent)
        }
    }
}
