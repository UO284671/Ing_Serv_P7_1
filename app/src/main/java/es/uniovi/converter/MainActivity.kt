package es.uniovi.converter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Toast
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    //DECLARACION DE VARIABLES
    var euroToDollar: Double = 1.16
    lateinit var editTextEuros: EditText
    lateinit var editTextDollars: EditText

    //METODO DE CREACION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INICIALIZAR CON LA VISTA
        editTextEuros = findViewById(R.id.editTextEuros)
        editTextDollars = findViewById(R.id.editTextDollars)
    }

    //METODO AUXILIAR PARA LA CONVERSION
    private fun convert(source: EditText, destination: EditText, factor: Double) {

        val text = source.text.toString()
        val value = text.toDoubleOrNull()

        //COMPROBACION DE QUE EL USUARIO INTRODUJO VALOR
        if (value == null) {
            destination.setText("")
            return
        }

        //CALCULAR Y MOSTRAR
        val result = value * factor
        destination.setText(result.toString())
    }

    //METODO PARA EL BOTON "TO DOLLARS"
    fun onClickToDollars(view: View) {
        convert(editTextEuros, editTextDollars, euroToDollar)
    }

    //METODO PARA EL BOTON "TO EUROS"
    fun onClickToEuros(view: View) {
        var dollarToEuro = 1 / euroToDollar
        convert(editTextDollars, editTextEuros, dollarToEuro)
    }
}
