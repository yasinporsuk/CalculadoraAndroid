package com.example.calculadora

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityBisiestoBinding

class BisiestoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBisiestoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el binding
        binding = ActivityBisiestoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evento del botón "Calcular"
        binding.btnCalcular.setOnClickListener {
            val anioStr = binding.etAnio.text.toString()
            if (anioStr.isNotEmpty()) {
                val anio = anioStr.toInt()
                if (esBisiesto(anio)) {
                    binding.tvResultado.text = "Es bisiesto"
                    binding.tvResultado.setTextColor(Color.GREEN)
                } else {
                    binding.tvResultado.text = "No es bisiesto"
                    binding.tvResultado.setTextColor(Color.RED)
                }
            } else {
                binding.tvResultado.text = "Introduce un año válido"
                binding.tvResultado.setTextColor(Color.RED)
            }
        }
    }

    private fun esBisiesto(anio: Int): Boolean {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
    }
}
