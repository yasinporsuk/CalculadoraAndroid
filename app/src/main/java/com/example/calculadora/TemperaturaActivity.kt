package com.example.calculadora

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityTemperaturaBinding

class TemperaturaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemperaturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val unidades = listOf("Celsius", "Fahrenheit", "Kelvin")

        //spinners y adaptadores
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerUnidadInicial.adapter = adapter
        binding.spinnerUnidadDestino.adapter = adapter

      //proceso de conversion
        binding.btnConvertir.setOnClickListener {
            val tempStr = binding.etTemperatura.text.toString()
            if (tempStr.isNotEmpty()) {
                val temperatura = tempStr.toDouble()
                val unidadInicial = binding.spinnerUnidadInicial.selectedItem.toString()
                val unidadDestino = binding.spinnerUnidadDestino.selectedItem.toString()

                // Realizamos la conversión y mostramos el resultado
                val resultado = convertirTemperatura(temperatura, unidadInicial, unidadDestino)
                binding.tvResultadoTemperatura.text = "Resultado: %.2f $unidadDestino".format(resultado)
            }
        }
    }

    private fun convertirTemperatura(temp: Double, unidadInicial: String, unidadDestino: String): Double {
        // Convertimos la temperatura a Kelvin primero para validar si está por debajo de 0K
        val tempEnKelvin = when (unidadInicial) {
            "Celsius" -> temp + 273.15
            "Fahrenheit" -> (temp - 32) * 5 / 9 + 273.15
            "Kelvin" -> temp
            else -> temp
        }

        // Limitar a 0 Kelvin si la temperatura es menor
        val temperaturaValida = if (tempEnKelvin < 0) 0.0 else tempEnKelvin

        // Convertir la temperatura válida desde Kelvin a la unidad de destino
        return when (unidadDestino) {
            "Celsius" -> temperaturaValida - 273.15
            "Fahrenheit" -> (temperaturaValida - 273.15) * 9 / 5 + 32
            "Kelvin" -> temperaturaValida
            else -> temperaturaValida
        }
    }
}
