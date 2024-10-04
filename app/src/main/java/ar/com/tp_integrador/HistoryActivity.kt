package ar.com.tp_integrador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.widget.Button
import android.widget.TextView


class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPreferences = this.getSharedPreferences("HistorialComparaciones", Context.MODE_PRIVATE)

        val comparacion1 = findViewById<TextView>(R.id.comparacion1)
        val comparacion2 = findViewById<TextView>(R.id.comparacion2)
        val comparacion3 = findViewById<TextView>(R.id.comparacion3)
        val comparacion4 = findViewById<TextView>(R.id.comparacion4)
        val comparacion5 = findViewById<TextView>(R.id.comparacion5)

        if (sharedPreferences.getAll().isEmpty()) {
            comparacion1.text = "No hay comparaciones guardadas."
        } else {
            val historial = mostrarHistorial()

            comparacion1.text = historial[0]
            comparacion2.text = historial[1]
            comparacion3.text = historial[2]
            comparacion4.text = historial[3]
            comparacion5.text = historial[4]
        }


        val btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }
    }


    fun mostrarHistorial(): Array<String> {
        val sharedPreferences = this.getSharedPreferences("HistorialComparaciones", Context.MODE_PRIVATE)

        val historial = Array(5) { "" }

        for (i in 0..4) {
            val capitalUno = sharedPreferences.getFloat("capitalInvUno$i", 0f)
            val tasaUno = sharedPreferences.getFloat("tnaInvUno$i", 0f)
            val plazoUno = sharedPreferences.getInt("plazoInvUno$i", 0)
            val entidadUno = sharedPreferences.getString("entidadInvUno$i","")

            val capitalDos = sharedPreferences.getFloat("capitalInvDos$i", 0f)
            val tasaDos = sharedPreferences.getFloat("tnaInvDos$i", 0f)
            val plazoDos = sharedPreferences.getInt("plazoInvDos$i", 0)
            val entidadDos = sharedPreferences.getString("entidadInvDos$i","")

            val roiUno = sharedPreferences.getFloat("roiInvUno$i", 0f)
            val roiDos = sharedPreferences.getFloat("roiInvDos$i", 0f)

            if (capitalUno != 0f && capitalDos != 0f) {
                historial[i] = """La opción de inversión 1 en la entidad $entidadUno se ingresó por un capital de $capitalUno
                con una TNA de $tasaUno% en un plazo de $plazoUno días y con un ROI resultante de $roiUno%.
                Mientras que la opción 2 en la entidad $entidadDos se ingresó por un capital de $capitalDos con una TNA de
                $tasaDos% en un plazo de $plazoDos días y con un ROI resultante de $roiDos%""".trimIndent()
            }
        }

        return historial
    }
}
