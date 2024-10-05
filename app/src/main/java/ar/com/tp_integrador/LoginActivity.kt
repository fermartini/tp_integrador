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

        //Llamo a cada una las id de las variables
        val nombre = findViewById<EditText>(R.id.nombre)
        val apellido = findViewById<EditText>(R.id.apellido)
        val correoElectronico = findViewById<EditText>(R.id.correoElectronico)
        val progressBar = findViewById<ProgressBar>(R.id.progreso)
        val botonIngresar = findViewById<Button>(R.id.botonIngresar)
        val botonTyC = findViewById<Button>(R.id.botonTyC)

        //Botón que abre el pop up donde se encuentran las políticas de términos y condiciones
        botonTyC.setOnClickListener {
                val dialog = TyCActivity()
                dialog.show(supportFragmentManager, "tyc")
                botonTyC.visibility = View.GONE
                botonIngresar.visibility = View.VISIBLE
            }

        //Botón ingresar
        botonIngresar.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val nombreUsuario = nombre.text.toString()
            val apellidoUsuario = apellido.text.toString()
            val correoUsuario = correoElectronico.text.toString()
            //Realizo el getSharedPreferences para que el resto de las activities accedan a los datos a los que les hago putString
            val datosPersonales = getSharedPreferences("userData", Context.MODE_PRIVATE)

            //Valida que ninguno de los valores solicitados quede vacío
            if(nombreUsuario.isNotEmpty() && apellidoUsuario.isNotEmpty() && correoUsuario.isNotEmpty()){
                datosPersonales.edit().apply {
                    putString("nombreUsuario", nombreUsuario)
                    putString("apellidoUsuario", apellidoUsuario)
                    putString("correoUsuario", correoUsuario)
                    apply()
                }
                progressBar.visibility = View.GONE
                //Mensaje de validación si se logueo correctamente
                Toast.makeText(this, "Logueo Válido", Toast.LENGTH_LONG).show()
                //Redirijo a la actividad del Test de Inversor
                val intent = Intent(this, TestActivity::class.java )
                startActivity(intent)
                finish()
            }
            else{
                //Mensaje que aparece para que el usuario complete la totalidad de los datos
                Toast.makeText(this, "Debe completar todos los datos solicitados", Toast.LENGTH_LONG).show()
            }
        }
    }
}