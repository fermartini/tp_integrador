package ar.com.tp_integrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buttons)



        val inversorSharedPreference = getSharedPreferences("userData", Context.MODE_PRIVATE)
        val name = inversorSharedPreference.getString("nombreUsuario", "Usuario")
        val tipoInversor = inversorSharedPreference.getString("tipoInversor", null)


        if (tipoInversor != null) {

            Toast.makeText(this, "Tipo de inversor es: $tipoInversor", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(this, "El tipo de inversor no está configurado", Toast.LENGTH_SHORT).show()
        }


        val greetingText = findViewById<TextView>(R.id.greetingText)
        val investorTypeText = findViewById<TextView>(R.id.investorTypeText)
        val btnHistorial = findViewById<Button>(R.id.btnHistorial)

        greetingText.text = "Hola, $name"
        investorTypeText.text = "Tipo de Inversor: ${tipoInversor ?: "Inversor General"}"


        findViewById<Button>(R.id.simulateButton).setOnClickListener {

            Toast.makeText(this, "Iniciando simulación...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CompareActivity::class.java)
            startActivity(intent)
            finish()
        }


        btnHistorial.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            logoutUser()
        }
    }

    private fun logoutUser() {
        val preferences = getSharedPreferences("userData", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()

        Toast.makeText(this, "Desconectado", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}