package ar.com.tp_integrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class TyCActivity : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Llamo a mi activity pero con inflater para que me haga el efecto estilo pop up
        val rootView: View = inflater.inflate(R.layout.activity_ty_cactivity, container, false)
        val leido = rootView.findViewById<Button>(R.id.botonLeido)

        //Botón Leído
        leido.setOnClickListener {
            dismiss()
            Toast.makeText(context, "Leídas las Políticas de Términos y Condiciones", Toast.LENGTH_LONG).show()
            }
        return rootView
    }

}