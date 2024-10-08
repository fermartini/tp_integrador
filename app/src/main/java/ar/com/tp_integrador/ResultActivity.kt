package ar.com.tp_integrador

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val roiUno = intent.getDoubleExtra("roiUno", 0.0)
        val roiDos = intent.getDoubleExtra("roiDos", 0.0)
        val comparacion = intent.getStringExtra("comparacion")


        val entidadUno = intent.getStringExtra("entidadUno")
        val capitalUno = intent.getDoubleExtra("capitalUno", 0.0)
        val tnaUno = intent.getDoubleExtra("tnaUno", 0.0)
        val plazoUno = intent.getIntExtra("plazoUno", 0)

        val entidadDos = intent.getStringExtra("entidadDos")
        val capitalDos = intent.getDoubleExtra("capitalDos", 0.0)
        val tnaDos = intent.getDoubleExtra("tnaDos", 0.0)
        val plazoDos = intent.getIntExtra("plazoDos", 0)


        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        resultadoTextView.text = """
            $comparacion
        """.trimIndent()

        val roiUnoTextView = findViewById<TextView>(R.id.roi_inversion_1)
        roiUnoTextView.text = "ROI: $roiUno"

        val capitalUnoTextView = findViewById<TextView>(R.id.capital_inversion_1)
        capitalUnoTextView.text = "Capital: $capitalUno"

        val plazoUnoTextView = findViewById<TextView>(R.id.plazo_inversion_1)
        plazoUnoTextView.text = "Plazo: $plazoUno"

        val roiDosTextView = findViewById<TextView>(R.id.roi_inversion_2)
        roiDosTextView.text = "ROI: $roiDos"

        val capitalDosTextView = findViewById<TextView>(R.id.capital_inversion_2)
        capitalDosTextView.text = "Capital: $capitalDos"

        val plazoDosTextView = findViewById<TextView>(R.id.plazo_inversion_2)
        plazoDosTextView.text = "Plazo: $plazoDos"

        val btnVolverAtras = findViewById<Button>(R.id.btnVolverAtras)
        btnVolverAtras.setOnClickListener {
            finish()
        }

    }
}