package ar.com.tp_integrador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CompareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_compare)
        
        val botonResultado = findViewById<Button>(R.id.botonRdo)

        botonResultado.setOnClickListener {
            val capitalUno = findViewById<EditText>(R.id.capitalUno).text.toString().toDouble()
            val tasaUno = findViewById<EditText>(R.id.tnaUno).text.toString().toDouble()
            val plazoUno = findViewById<EditText>(R.id.plazoUno).text.toString().toInt()
            val entidadUno = findViewById<EditText>(R.id.entidadUno).text.toString()

            val capitalDos = findViewById<EditText>(R.id.capitalDos).text.toString().toDouble()
            val tasaDos = findViewById<EditText>(R.id.tnaDos).text.toString().toDouble()
            val plazoDos = findViewById<EditText>(R.id.plazoDos).text.toString().toInt()
            val entidadDos = findViewById<EditText>(R.id.entidadDos).text.toString()




            // Esto es para primero calcular los ROIs a comparar
            val roiUno = calcularROI(capitalUno, tasaUno, plazoUno)
            val roiDos = calcularROI(capitalDos, tasaDos, plazoDos)

            val comparacion = compararInversiones(roiUno, roiDos)

            // Mando los resultados y los datos a ResultadoActivity para mostrarlo por pantalla
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("roiUno", roiUno)
            intent.putExtra("roiDos", roiDos)
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
        }
        val botonVolverAtras= findViewById<Button>(R.id.btnVolverAtras)
        botonVolverAtras.setOnClickListener {
            val intent = Intent(this, ButtonsActivity::class.java)
            startActivity(intent)
        }
    }

    fun calcularROI(capital: Double, tasa: Double, plazo: Int): Double {
        val tasaDiaria = tasa / 100 / 365
        val capitalFinal = capital * Math.pow(1 + tasaDiaria, plazo.toDouble())
        val roi = ((capitalFinal - capital) / capital) * 100

        // Lo limito a 5 decimales para cumplir con la consigna y que no ocupe toda la pantalla con números poco significativos
        return String.format("%.5f", roi).toDouble()
    }

    fun compararInversiones(roiUno: Double, roiDos: Double): String {
        return if (roiUno > roiDos) {
            "La primera inversión es mejor."
        } else if (roiDos > roiUno) {
            "La segunda inversión es mejor."
        } else {
            "Ambas inversiones tienen el mismo rendimiento."
        }
    }
}
