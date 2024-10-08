package ar.com.tp_integrador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class CompareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_compare)
        val botonResultado = findViewById<Button>(R.id.botonRdo)
        val botonAtras = findViewById<Button>(R.id.btnVolverAtras)

        botonAtras.setOnClickListener {
            val intent = Intent(this, ButtonsActivity::class.java)
            startActivity(intent)
            finish()
        }

        botonResultado.setOnClickListener {

            val capitalUnoField = findViewById<EditText>(R.id.capitalUno)
            val tasaUnoField = findViewById<EditText>(R.id.tnaUno)
            val plazoUnoField = findViewById<EditText>(R.id.plazoUno)
            val entidadUnoField = findViewById<EditText>(R.id.entidadUno)

            val capitalDosField = findViewById<EditText>(R.id.capitalDos)
            val tasaDosField = findViewById<EditText>(R.id.tnaDos)
            val plazoDosField = findViewById<EditText>(R.id.plazoDos)
            val entidadDosField = findViewById<EditText>(R.id.entidadDos)



            if (capitalUnoField.text.isNullOrEmpty() || tasaUnoField.text.isNullOrEmpty() ||
                plazoUnoField.text.isNullOrEmpty() || entidadUnoField.text.isNullOrEmpty() ||
                capitalDosField.text.isNullOrEmpty() || tasaDosField.text.isNullOrEmpty() ||
                plazoDosField.text.isNullOrEmpty() || entidadDosField.text.isNullOrEmpty()) {


                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {

                val capitalUno = capitalUnoField.text.toString().toDouble()
                val tasaUno = tasaUnoField.text.toString().toDouble()
                val plazoUno = plazoUnoField.text.toString().toInt()
                val entidadUno = entidadUnoField.text.toString()

                val capitalDos = capitalDosField.text.toString().toDouble()
                val tasaDos = tasaDosField.text.toString().toDouble()
                val plazoDos = plazoDosField.text.toString().toInt()
                val entidadDos = entidadDosField.text.toString()


                val roiUno = calcularROI(capitalUno, tasaUno, plazoUno)
                val capitalFinalUno = calcularCapitalFinal(capitalUno, tasaUno, plazoUno).toDouble()

                val roiDos = calcularROI(capitalDos, tasaDos, plazoDos)
                val capitalFinalDos = calcularCapitalFinal(capitalDos, tasaDos, plazoDos).toDouble()

                val comparacion = compararInversiones(roiUno, roiDos)



                // Mando los resultados y los datos a ResultadoActivity usando Intents
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("roiUno", roiUno)
                intent.putExtra("capitalFinalUno", capitalFinalUno.toDouble())
                intent.putExtra("roiDos", roiDos)
                intent.putExtra("capitalFinalDos", capitalFinalDos.toDouble())
                intent.putExtra("comparacion", comparacion)

                intent.putExtra("entidadUno", entidadUno)
                intent.putExtra("entidadDos", entidadDos)
                intent.putExtra("capitalUno", capitalUno)
                intent.putExtra("tnaUno", tasaUno)
                intent.putExtra("plazoUno", plazoUno)
                intent.putExtra("capitalDos", capitalDos)
                intent.putExtra("tnaDos", tasaDos)
                intent.putExtra("plazoDos", plazoDos)
                startActivity(intent)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun calcularROI(capital: Double, tasa: Double, plazo: Int): Double {
        val tasaDiaria = tasa / 100 / 365
        val capitalFinal = capital * Math.pow(1 + tasaDiaria, plazo.toDouble())
        val roi = ((capitalFinal - capital) / capital) * 100
        // Lo limito a 5 decimales para cumplir con la consigna y que no ocupe toda la pantalla con números poco significativos
        return String.format("%.5f", roi).toDouble()
    }

    fun calcularCapitalFinal(capital: Double, tasa: Double, plazo: Int): Double {
        val tasaDiaria = tasa / 100 / 365
        val capitalFinal = capital * Math.pow(1 + tasaDiaria, plazo.toDouble())
        return String.format("%.5f", capitalFinal).toDouble() // Limitar a 2 decimales
    }


    fun compararInversiones(roiUno: Double, roiDos: Double): String {
        return when {
            roiUno > roiDos -> "La primera inversión es mejor."
            roiDos > roiUno -> "La segunda inversión es mejor."
            else -> "Ambas inversiones tienen el mismo rendimiento."
        }
    }
}