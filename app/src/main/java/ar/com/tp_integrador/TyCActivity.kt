package ar.com.tp_integrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class TyCActivity : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.activity_ty_cactivity, container, false)
        val aceptar = rootView.findViewById<Button>(R.id.botonAceptar)
        val checked = rootView.findViewById<CheckBox>(R.id.checkedTyC)

        aceptar.setOnClickListener {
            if(checked.isChecked){
                dismiss()
            }   else {
                Toast.makeText(context, "Debe aceptar los Términos y Condiciones para poder continuar", Toast.LENGTH_LONG).show()
            }
        }
        return rootView
    }
}