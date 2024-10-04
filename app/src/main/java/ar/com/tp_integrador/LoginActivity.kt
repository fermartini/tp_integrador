package ar.com.tp_integrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val nombre = findViewById<EditText>(R.id.nombre)
        val apellido = findViewById<EditText>(R.id.apellido)
        val correoElectronico = findViewById<EditText>(R.id.correoElectronico)
        val progressBar = findViewById<ProgressBar>(R.id.progreso)
        val botonIngresar = findViewById<Button>(R.id.botonIngresar)
        val botonTyC = findViewById<Button>(R.id.botonTyC)

        // TODO ver cómo hacer para que devuelva un valor en el cual si bien active el botón ingresar, haya dado antes aceptar a las bases y condiciones
        botonTyC.setOnClickListener {
                val dialog = TyCActivity()
                dialog.show(supportFragmentManager, "tyc")
                botonTyC.visibility = View.GONE
                botonIngresar.visibility = View.VISIBLE
            }

        botonIngresar.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val nombreUsuario = nombre.text.toString()
            val apellidoUsuario = apellido.text.toString()
            val correoUsuario = correoElectronico.text.toString()
            val datosPersonales = getSharedPreferences("userData", Context.MODE_PRIVATE)

            if(nombreUsuario.isNotEmpty() && apellidoUsuario.isNotEmpty() && correoUsuario.isNotEmpty()){
                datosPersonales.edit().apply {
                    putString("nombreUsuario", nombreUsuario)
                    putString("apellidoUsuario", apellidoUsuario)
                    putString("correoUsuario", correoUsuario)
                    apply()
                }
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Logueo Válido", Toast.LENGTH_LONG).show()
                val intent = Intent(this, TestActivity::class.java )
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Debe completar todos los datos solicitados", Toast.LENGTH_LONG).show()
            }
        }
    }
}