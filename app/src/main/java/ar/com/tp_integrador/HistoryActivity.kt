package ar.com.tp_integrador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.SharedPreferences
import android.view.View
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

        val btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }

        val entidadUnoTextViews = listOf(
            R.id.entidadUno1, R.id.entidadUno2, R.id.entidadUno3, R.id.entidadUno4, R.id.entidadUno5
        )
        val capitalUnoTextViews = listOf(
            R.id.capitalUno1, R.id.capitalUno2, R.id.capitalUno3, R.id.capitalUno4, R.id.capitalUno5
        )
        val plazoUnoTextViews = listOf(
            R.id.plazoUno1, R.id.plazoUno2, R.id.plazoUno3, R.id.plazoUno4, R.id.plazoUno5
        )
        val roiUnoTextViews = listOf(
            R.id.roiUno1, R.id.roiUno2, R.id.roiUno3, R.id.roiUno4, R.id.roiUno5
        )

        val entidadDosTextViews = listOf(
            R.id.entidadDos1, R.id.entidadDos2, R.id.entidadDos3, R.id.entidadDos4, R.id.entidadDos5
        )
        val capitalDosTextViews = listOf(
            R.id.capitalDos1, R.id.capitalDos2, R.id.capitalDos3, R.id.capitalDos4, R.id.capitalDos5
        )
        val plazoDosTextViews = listOf(
            R.id.plazoDos1, R.id.plazoDos2, R.id.plazoDos3, R.id.plazoDos4, R.id.plazoDos5
        )
        val roiDosTextViews = listOf(
            R.id.roiDos1, R.id.roiDos2, R.id.roiDos3, R.id.roiDos4, R.id.roiDos5
        )

        val sharedPreferences = getSharedPreferences("HistorialComparaciones", Context.MODE_PRIVATE)

        // para que sean máximo 5 comparaciones
        for (i in 0 until entidadUnoTextViews.size) {

            val entidadUno = sharedPreferences.getString("entidadInvUno$i", "")
            val capitalUno = sharedPreferences.getFloat("capitalInvUno$i", 0f)
            val plazoUno = sharedPreferences.getInt("plazoInvUno$i", 0)
            val roiUno = sharedPreferences.getFloat("roiInvUno$i", 0f)

            val entidadDos = sharedPreferences.getString("entidadInvDos$i", "")
            val capitalDos = sharedPreferences.getFloat("capitalInvDos$i", 0f)
            val plazoDos = sharedPreferences.getInt("plazoInvDos$i", 0)
            val roiDos = sharedPreferences.getFloat("roiInvDos$i", 0f)


            val entidadUnoTextView = findViewById<TextView>(entidadUnoTextViews[i])
            val capitalUnoTextView = findViewById<TextView>(capitalUnoTextViews[i])
            val plazoUnoTextView = findViewById<TextView>(plazoUnoTextViews[i])
            val roiUnoTextView = findViewById<TextView>(roiUnoTextViews[i])

            val entidadDosTextView = findViewById<TextView>(entidadDosTextViews[i])
            val capitalDosTextView = findViewById<TextView>(capitalDosTextViews[i])
            val plazoDosTextView = findViewById<TextView>(plazoDosTextViews[i])
            val roiDosTextView = findViewById<TextView>(roiDosTextViews[i])

            // esto es para que no se muestren inversiones vacías
            // (creo q también se le podría cambiar directamente la visibilidad al linearlayout completo de cada comparación, habría q ubicarlos y cambiarlo) ^^
            if (capitalUno == 0f && capitalDos == 0f) {

                entidadUnoTextView.visibility = View.GONE
                capitalUnoTextView.visibility = View.GONE
                plazoUnoTextView.visibility = View.GONE
                roiUnoTextView.visibility = View.GONE

                entidadDosTextView.visibility = View.GONE
                capitalDosTextView.visibility = View.GONE
                plazoDosTextView.visibility = View.GONE
                roiDosTextView.visibility = View.GONE
            } else {

                entidadUnoTextView.text = "1. $entidadUno"
                capitalUnoTextView.text = "Capital 1: $$capitalUno"
                plazoUnoTextView.text = "Plazo 1: $plazoUno días"
                roiUnoTextView.text = "ROI 1: $roiUno%"

                entidadDosTextView.text = "2. $entidadDos"
                capitalDosTextView.text = "Capital 2: $$capitalDos"
                plazoDosTextView.text = "Plazo 2: $plazoDos días"
                roiDosTextView.text = "ROI 2: $roiDos%"


                entidadUnoTextView.visibility = View.VISIBLE
                capitalUnoTextView.visibility = View.VISIBLE
                plazoUnoTextView.visibility = View.VISIBLE
                roiUnoTextView.visibility = View.VISIBLE

                entidadDosTextView.visibility = View.VISIBLE
                capitalDosTextView.visibility = View.VISIBLE
                plazoDosTextView.visibility = View.VISIBLE
                roiDosTextView.visibility = View.VISIBLE
            }
        }
    }}