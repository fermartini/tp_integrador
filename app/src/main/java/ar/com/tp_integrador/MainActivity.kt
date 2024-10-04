package ar.com.tp_integrador

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inversorSharedPreference = getSharedPreferences("userData", Context.MODE_PRIVATE)

        val inversor = inversorSharedPreference.getString("tipoInversor", null)

        if(inversor != null){
            val intent = Intent(this, ButtonsActivity::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}