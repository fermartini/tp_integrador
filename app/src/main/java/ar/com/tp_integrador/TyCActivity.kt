package ar.com.tp_integrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlin.system.exitProcess

class TyCActivity : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Llamo a mi activity pero con inflater para que me haga el efecto estilo pop up
        val rootView: View = inflater.inflate(R.layout.activity_ty_cactivity, container, false)
        val aceptar = rootView.findViewById<Button>(R.id.botonAceptar)
        val checked = rootView.findViewById<CheckBox>(R.id.checkedTyC)
        val noAceptar = rootView.findViewById<Button>(R.id.botonNoAceptar)

        //Botón aceptar
        aceptar.setOnClickListener {
            //Validación para que el usuario marque el check sí o sí
            if(checked.isChecked){
                //si lo hace, se cierra el pop up
                dismiss()
            }   else {
                //Mensaje advertencia para que tilde el check si quiere continuar
                Toast.makeText(context, "Debe aceptar los Términos y Condiciones para poder continuar", Toast.LENGTH_LONG).show()
            }
        }

        //Botón no acepta
        noAceptar.setOnClickListener {
            //Mensaje que le avisa al usuario que al no aceptar las bases y condiciones se cerrará la app
            Toast.makeText(context, "Al no aceptar los Términos y Condiciones, se cierra la aplicación.", Toast.LENGTH_LONG).show()
            exitProcess(0)
        }

        return rootView
    }
}