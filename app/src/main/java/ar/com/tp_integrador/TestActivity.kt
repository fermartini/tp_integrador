package ar.com.tp_integrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test)
        //Guardamos los RadioButton
        val rgAnswer1 = findViewById<RadioGroup>(R.id.answer1)
        val rgAnswer2 = findViewById<RadioGroup>(R.id.answer2)
        val rgAnswer3 = findViewById<RadioGroup>(R.id.answer3)
        //guardamos el boton
        val btnSend = findViewById<Button>(R.id.btnSend)
        //Variable para sumar respuestas
        var sumAnswer = 0
        //Variable para tipo de inversor
        var tipoInversor = ""
        //Valores maximos de los tipos de inversor
        val inversorConservador = 4
        val inversorModerado = 7

        //Variable shared preference
        val inversorSharedPreference = getSharedPreferences("userData", Context.MODE_PRIVATE)


        btnSend.setOnClickListener {
            val selectedAnswer1 = rgAnswer1.checkedRadioButtonId
            val selectedAnswer2 = rgAnswer2.checkedRadioButtonId
            val selectedAnswer3 = rgAnswer3.checkedRadioButtonId

            if(selectedAnswer1 != -1 && selectedAnswer2 !=-1 && selectedAnswer3 != -1) {
                //Traemos los ID de los radio button
                val answer1 = findViewById<RadioButton>(selectedAnswer1)
                val answer2 = findViewById<RadioButton>(selectedAnswer2)
                val answer3 = findViewById<RadioButton>(selectedAnswer3)
                //sumamos los valores de las respuestas elegidas, para luego analizar que inversor es.
                sumAnswer = answer1.tag.toString().toInt() + answer2.tag.toString().toInt() + answer3.tag.toString().toInt()

                if(sumAnswer <= inversorConservador){
                    tipoInversor = "Conservador"
                }else if (sumAnswer <= inversorModerado){
                    tipoInversor = "Moderado"
                }else{
                    tipoInversor = "Agresivo"
                }

                inversorSharedPreference.edit().apply{
                    putString("tipoInversor", tipoInversor)
                    apply()
                }

                val intent = Intent(this, ButtonsActivity::class.java)
                startActivity(intent)
                finish()

            }else{
                //Toast, que sale cuando falta seleccionar alguna opcion
                Toast.makeText(this, "Falta seleccionar opciones", Toast.LENGTH_LONG).show()
            }
        }
    }
}