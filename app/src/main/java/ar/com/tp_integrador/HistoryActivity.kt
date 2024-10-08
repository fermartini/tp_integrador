package ar.com.tp_integrador

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val entidadUnoTextView1 = findViewById<TextView>(R.id.entidadUno1)
        val capitalUnoTextView1 = findViewById<TextView>(R.id.capitalUno1)
        val plazoUnoTextView1 = findViewById<TextView>(R.id.plazoUno1)
        val roiUnoTextView1 = findViewById<TextView>(R.id.roiUno1)

        val entidadDosTextView1 = findViewById<TextView>(R.id.entidadDos1)
        val capitalDosTextView1 = findViewById<TextView>(R.id.capitalDos1)
        val plazoDosTextView1 = findViewById<TextView>(R.id.plazoDos1)
        val roiDosTextView1 = findViewById<TextView>(R.id.roiDos1)

        val sharedPreferences = getSharedPreferences("HistorialComparaciones", Context.MODE_PRIVATE)

        val entidadUno1 = sharedPreferences.getString("entidadInvUno0","")
        val capitalUno1 = sharedPreferences.getFloat("capitalInvUno0", 0f)
        val plazoUno1 = sharedPreferences.getInt("plazoInvUno0", 0)
        val roiUno1 = sharedPreferences.getFloat("roiInvUno0", 0f)

        val entidadDos1 = sharedPreferences.getString("entidadInvDos0","")
        val capitalDos1 = sharedPreferences.getFloat("capitalInvDos0", 0f)
        val plazoDos1 = sharedPreferences.getInt("plazoInvDos0", 0)
        val roiDos1 = sharedPreferences.getFloat("roiInvDos0", 0f)


        if (capitalUno1 != 0f && capitalDos1 != 0f) {
            entidadUnoTextView1.text="Entidad 1: $entidadUno1"
            capitalUnoTextView1.text = "Capital 1: $capitalUno1"
            plazoUnoTextView1.text = "Plazo 1: $plazoUno1 días"
            roiUnoTextView1.text = "ROI 1: $roiUno1%"

            entidadDosTextView1.text="Entidad 2: $entidadDos1"
            capitalDosTextView1.text = "Capital 2: $capitalDos1"
            plazoDosTextView1.text = "Plazo 2: $plazoDos1 días"
            roiDosTextView1.text = "ROI 2: $roiDos1%"
        } else {
            entidadUnoTextView1.text= "No hay comparaciones guardadas"
            entidadDosTextView1.text= ""
            capitalUnoTextView1.text = ""
            capitalDosTextView1.text = ""
            plazoUnoTextView1.text = ""
            roiUnoTextView1.text = ""
            plazoDosTextView1.text = ""
            roiDosTextView1.text = ""
        }
        /*comparacion2*/
        val entidadUnoTextView2 = findViewById<TextView>(R.id.entidadUno2)
        val capitalUnoTextView2 = findViewById<TextView>(R.id.capitalUno2)
        val plazoUnoTextView2 = findViewById<TextView>(R.id.plazoUno2)
        val roiUnoTextView2 = findViewById<TextView>(R.id.roiUno2)

        val entidadDosTextView2 = findViewById<TextView>(R.id.entidadDos2)
        val capitalDosTextView2 = findViewById<TextView>(R.id.capitalDos2)
        val plazoDosTextView2 = findViewById<TextView>(R.id.plazoDos2)
        val roiDosTextView2 = findViewById<TextView>(R.id.roiDos2)

        val entidadUno2 = sharedPreferences.getString("entidadInvUno2","")
        val capitalUno2 = sharedPreferences.getFloat("capitalInvUno2", 0f)
        val plazoUno2 = sharedPreferences.getInt("plazoInvUno2", 0)
        val roiUno2 = sharedPreferences.getFloat("roiInvUno2", 0f)

        val entidadDos2 = sharedPreferences.getString("entidadInvDos2","")
        val capitalDos2 = sharedPreferences.getFloat("capitalInvDos2", 0f)
        val plazoDos2 = sharedPreferences.getInt("plazoInvDos2", 0)
        val roiDos2 = sharedPreferences.getFloat("roiInvDos2", 0f)

        if (capitalUno2 != 0f && capitalDos2 != 0f) {
            entidadUnoTextView2.text ="Entidad 1: $entidadUno2"
            capitalUnoTextView2.text = "Capital 1: $capitalUno2"
            plazoUnoTextView2.text = "Plazo 1: $plazoUno2 días"
            roiUnoTextView2.text = "ROI 1: $roiUno2%"

            entidadDosTextView2.text ="Entidad 1: $entidadDos2"
            capitalDosTextView2.text = "Capital 2: $capitalDos2"
            plazoDosTextView2.text = "Plazo 2: $plazoDos2 días"
            roiDosTextView2.text = "ROI 2: $roiDos2%"
        } else {
            entidadUnoTextView2.text= "No hay comparaciones guardadas"
            entidadDosTextView2.text=""
            capitalUnoTextView2.text = ""
            capitalDosTextView2.text = ""
            plazoUnoTextView2.text = ""
            roiUnoTextView2.text = ""
            plazoDosTextView2.text = ""
            roiDosTextView2.text = ""
        }

        /*comparacion3*/
        val entidadUnoTextView3= findViewById<TextView>(R.id.entidadUno3)
        val capitalUnoTextView3 = findViewById<TextView>(R.id.capitalUno3)
        val plazoUnoTextView3 = findViewById<TextView>(R.id.plazoUno3)
        val roiUnoTextView3 = findViewById<TextView>(R.id.roiUno3)

        val entidadDosTextView3= findViewById<TextView>(R.id.entidadDos3)
        val capitalDosTextView3 = findViewById<TextView>(R.id.capitalDos3)
        val plazoDosTextView3 = findViewById<TextView>(R.id.plazoDos3)
        val roiDosTextView3 = findViewById<TextView>(R.id.roiDos3)

        val entidadUno3 =sharedPreferences.getString("entidadInvUno3","")
        val capitalUno3 = sharedPreferences.getFloat("capitalInvUno3", 0f)
        val plazoUno3 = sharedPreferences.getInt("plazoInvUno3", 0)
        val roiUno3 = sharedPreferences.getFloat("roiInvUno3", 0f)

        val entidadDos3 =sharedPreferences.getString("entidadInvDos3","")
        val capitalDos3 = sharedPreferences.getFloat("capitalInvDos3", 0f)
        val plazoDos3 = sharedPreferences.getInt("plazoInvDos3", 0)
        val roiDos3 = sharedPreferences.getFloat("roiInvDos3", 0f)

        if (capitalUno3 != 0f && capitalDos3 != 0f) {
            entidadUnoTextView3.text = "Entidad 1: $entidadUno3"
            capitalUnoTextView3.text = "Capital 1: $capitalUno3"
            plazoUnoTextView3.text = "Plazo 1: $plazoUno3 días"
            roiUnoTextView3.text = "ROI 1: $roiUno3%"

            entidadDosTextView3.text = "Entidad 1: $entidadDos3"
            capitalDosTextView3.text = "Capital 2: $capitalDos3"
            plazoDosTextView3.text = "Plazo 2: $plazoDos3 días"
            roiDosTextView3.text = "ROI 2: $roiDos3%"
        } else {
            entidadUnoTextView3.text= "No hay comparaciones guardadas"
            entidadDosTextView3.text= ""
            capitalUnoTextView3.text = ""
            capitalDosTextView3.text = ""
            plazoUnoTextView3.text = ""
            roiUnoTextView3.text = ""
            plazoDosTextView3.text = ""
            roiDosTextView3.text = ""
        }
        /*comparacion4*/

        val entidadUnoTextView4= findViewById<TextView>(R.id.entidadUno4)
        val capitalUnoTextView4 = findViewById<TextView>(R.id.capitalUno4)
        val plazoUnoTextView4 = findViewById<TextView>(R.id.plazoUno4)
        val roiUnoTextView4 = findViewById<TextView>(R.id.roiUno4)

        val entidadDosTextView4 = findViewById<TextView>(R.id.entidadDos4)
        val capitalDosTextView4 = findViewById<TextView>(R.id.capitalDos4)
        val plazoDosTextView4 = findViewById<TextView>(R.id.plazoDos4)
        val roiDosTextView4 = findViewById<TextView>(R.id.roiDos4)

        val entidadUno4 = sharedPreferences.getString("entidadInvUno4","")
        val capitalUno4 = sharedPreferences.getFloat("capitalInvUno4", 0f)
        val plazoUno4 = sharedPreferences.getInt("plazoInvUno4", 0)
        val roiUno4 = sharedPreferences.getFloat("roiInvUno4", 0f)

        val entidadDos4 = sharedPreferences.getString("entidadInvDos4","")
        val capitalDos4 = sharedPreferences.getFloat("capitalInvDos4", 0f)
        val plazoDos4 = sharedPreferences.getInt("plazoInvDos4", 0)
        val roiDos4 = sharedPreferences.getFloat("roiInvDos4", 0f)

        if (capitalUno4 != 0f && capitalDos4 != 0f) {
            entidadUnoTextView4.text= "Entidad 1: $entidadUno4"
            capitalUnoTextView4.text = "Capital 1: $capitalUno4"
            plazoUnoTextView4.text = "Plazo 1: $plazoUno4 días"
            roiUnoTextView4.text = "ROI 1: $roiUno4%"

            entidadDosTextView4.text = "Entidad 2: $entidadDos4"
            capitalDosTextView4.text = "Capital 2: $capitalDos4"
            plazoDosTextView4.text = "Plazo 2: $plazoDos4 días"
            roiDosTextView4.text = "ROI 2: $roiDos4%"
        } else {
            entidadUnoTextView4.text = "No hay comparaciones guardadas"
            entidadDosTextView4.text = ""
            capitalUnoTextView4.text = ""
            capitalDosTextView4.text = ""
            plazoUnoTextView4.text = ""
            roiUnoTextView4.text = ""
            plazoDosTextView4.text = ""
            roiDosTextView4.text = ""
        }
        /*comparacion5*/


        val entidadUnoTextView5 = findViewById<TextView>(R.id.entidadUno5)
        val capitalUnoTextView5 = findViewById<TextView>(R.id.capitalUno5)
        val plazoUnoTextView5 = findViewById<TextView>(R.id.plazoUno5)
        val roiUnoTextView5 = findViewById<TextView>(R.id.roiUno5)

        val entidadDosTextView5 = findViewById<TextView>(R.id.entidadDos5)
        val capitalDosTextView5 = findViewById<TextView>(R.id.capitalDos5)
        val plazoDosTextView5 = findViewById<TextView>(R.id.plazoDos5)
        val roiDosTextView5 = findViewById<TextView>(R.id.roiDos5)


        val entidadUno5 = sharedPreferences.getString("entidadInvUno5","")
        val capitalUno5 = sharedPreferences.getFloat("capitalInvUno5", 0f)
        val plazoUno5 = sharedPreferences.getInt("plazoInvUno5", 0)
        val roiUno5 = sharedPreferences.getFloat("roiInvUno5", 0f)

        val entidadDos5 = sharedPreferences.getString("entidadInvDos5","")
        val capitalDos5 = sharedPreferences.getFloat("capitalInvDos5", 0f)
        val plazoDos5 = sharedPreferences.getInt("plazoInvDos5", 0)
        val roiDos5 = sharedPreferences.getFloat("roiInvDos5", 0f)

        if (capitalUno5 != 0f && capitalDos5 != 0f) {
            entidadUnoTextView5.text = "Entidad 1: $entidadUno5"
            capitalUnoTextView5.text = "Capital 1: $capitalUno5"
            plazoUnoTextView5.text = "Plazo 1: $plazoUno5 días"
            roiUnoTextView5.text = "ROI 1: $roiUno5%"

            entidadDosTextView5.text= "Entidad 2: $entidadDos5"
            capitalDosTextView5.text = "Capital 2: $capitalDos5"
            plazoDosTextView5.text = "Plazo 2: $plazoDos5 días"
            roiDosTextView5.text = "ROI 2: $roiDos5%"
        } else {
            entidadUnoTextView5.text = "No hay comparaciones guardadas"
            entidadDosTextView5.text =""
            capitalUnoTextView5.text = ""
            capitalDosTextView5.text = ""
            plazoUnoTextView5.text = ""
            roiUnoTextView5.text = ""
            plazoDosTextView5.text = ""
            roiDosTextView5.text = ""
        }



        val btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener {
            finish()
        }
    }
}



