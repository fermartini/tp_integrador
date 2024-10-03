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


        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        resultadoTextView.text = """
            $comparacion
        """.trimIndent()

        val roiUnoTextView = findViewById<TextView>(R.id.roi_inversion_1)
        roiUnoTextView.text = "ROI: $roiUno"

        val roiDosTextView = findViewById<TextView>(R.id.roi_inversion_2)
        roiDosTextView.text = "ROI: $roiDos"

        val entidadUno = intent.getStringExtra("entidadUno")
        val capitalUno = intent.getDoubleExtra("capitalUno", 0.0)
        val tnaUno = intent.getDoubleExtra("tnaUno", 0.0)
        val plazoUno = intent.getIntExtra("plazoUno", 0)

        val entidadDos = intent.getStringExtra("entidadDos")
        val capitalDos = intent.getDoubleExtra("capitalDos", 0.0)
        val tnaDos = intent.getDoubleExtra("tnaDos", 0.0)
        val plazoDos = intent.getIntExtra("plazoDos", 0)

        val btnVolverAtras = findViewById<Button>(R.id.btnVolverAtras)
        btnVolverAtras.setOnClickListener {
            finish()
        }

                val btnGuardarInversion = findViewById<Button>(R.id.btnGuardarInversion)
        btnGuardarInversion.setOnClickListener {
                guardarComparacion(entidadUno, capitalUno, tnaUno, plazoUno, roiUno, entidadDos,
                    capitalDos, tnaDos, plazoDos, roiDos)
            }
        }
    }
}

fun guardarComparacion(entidadUno: String?, capitalUno: Double, tnaUno: Double, plazoUno: Int, roiUno: Double,
                   entidadDos: String?, capitalDos: Double, tnaDos: Double, plazoDos: Int, roiDos: Double) {
    val sharedPreferences = getSharedPreferences("HistorialComparaciones", MODE_PRIVATE)
    val archivadorDatos = sharedPreferences.edit()

    for (i in 5 downTo 1) {
        archivadorDatos.putFloat("capitalInvUno$i", sharedPreferences.getFloat("capitalInvUno${i - 1}", 0f))
        archivadorDatos.putFloat("tnaInvUno$i", sharedPreferences.getFloat("tnaInvUno${i - 1}", 0f))
        archivadorDatos.putInt("plazoInvUno$i", sharedPreferences.getInt("plazoInvUno${i - 1}", 0))
        archivadorDatos.putFloat("roiInvUno$i", sharedPreferences.getFloat("roiInvUno${i - 1}", 0f))

        archivadorDatos.putFloat("capitalInv2$i", sharedPreferences.getFloat("capitalInvDos${i - 1}", 0f))
        archivadorDatos.putFloat("tnaInvDos$i", sharedPreferences.getFloat("tnaInvDos${i - 1}", 0f))
        archivadorDatos.putInt("plazoInvDos$i", sharedPreferences.getInt("plazoInvDos${i - 1}", 0))
        archivadorDatos.putFloat("roiInvDos$i", sharedPreferences.getFloat("roiInvDos${i - 1}", 0f))
    }

    archivadorDatos.putFloat("capitalInvUno", capitalUno.toFloat())
    archivadorDatos.putFloat("tnaInvUno", tnaUno.toFloat())
    archivadorDatos.putInt("plazoInvUno", plazoUno)
    archivadorDatos.putFloat("roiInvUno", roiUno.toFloat())

    archivadorDatos.putFloat("capitalInvDos", capitalDos.toFloat())
    archivadorDatos.putFloat("tnaInvDos", tnaDos.toFloat())
    archivadorDatos.putInt("plazoInvDos", plazoDos)
    archivadorDatos.putFloat("roiInvDos", roiDos.toFloat())

    archivadorDatos.apply()

    Toast.makeText(this, "Comparación guardada exitosamente", Toast.LENGTH_SHORT).show()
}
