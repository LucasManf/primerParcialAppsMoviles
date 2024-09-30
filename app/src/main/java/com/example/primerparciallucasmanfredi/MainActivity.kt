package com.example.primerparciallucasmanfredi

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //Declaracion de variables del UI
    private lateinit var button: Button
    private lateinit var nationET1: EditText
    private lateinit var nationET2: EditText
    private lateinit var nationET3: EditText

    //Declaracion de variables para los nombres de paises ingresados
    private lateinit var nationName1: String
    private lateinit var nationName2: String
    private lateinit var nationName3: String

    private val intentHelper = IntentHelper() //Instancia de la clase IntentHelper para pasar de una actividad a otra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializacion de elementos de UI
        button = findViewById(R.id.button1)
        nationET1 = findViewById(R.id.paisET1)
        nationET2 = findViewById(R.id.paisET2)
        nationET3 = findViewById(R.id.paisET3)

        //On click listener del boton "Continuar"
        button.setOnClickListener {

            //Verificar si se ingresaron 3 paises
            if (validarPaisesIngresados(nationET1.text, nationET2.text, nationET3.text)){
                nationName1 = nationET1.text.toString()
                nationName2 = nationET2.text.toString()
                nationName3 = nationET3.text.toString()

                //Verificar si los paises ingresados estan dentro de los aceptados
                if(validarPaisesAceptados(nationName1, nationName2, nationName3)) {

                    //Verificar si los paises ingresados estan repetidos o no
                    if (noPaisesRepetidos(nationName1, nationName2, nationName3)) {
                        intentHelper.doIntent(this, nationName1, nationName2, nationName3)
                    } else {
                        //Mensaje si hay paises repetidos
                        Toast.makeText(this, "Ingrese 3 paises distintos", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    //Mensaje si hay paises no validos
                    Toast.makeText(this, "Ingrese paises validos. \nPaises aceptados:", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Argentina, Brasil, Chile,\nColombia, Uruguay", Toast.LENGTH_SHORT).show()
                }

            } else {
                //Mensaje si no se ingresaron 3 paises
                Toast.makeText(this, "Ingrese 3 paises", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Funcion para verificar si los paises ingresados son validos
    fun validarPaisesAceptados(pais1: String, pais2: String, pais3: String): Boolean {
        try {
            //Verificar si los nombres de los paises, pasados a mayuscula, estan dentro de la clase enum
            val paisEnum1 = Pais.valueOf(pais1.uppercase())
            val paisEnum2 = Pais.valueOf(pais2.uppercase())
            val paisEnum3 = Pais.valueOf(pais3.uppercase())
            return paisEnum1 in Pais.values() &&
                    paisEnum2 in Pais.values() &&
                    paisEnum3 in Pais.values()

        } catch (e: IllegalArgumentException) {
            return false
        }
    }

    //Funcion para verificar si se ingresaron 3 paises
    fun validarPaisesIngresados(pais1: Editable, pais2: Editable, pais3: Editable): Boolean {
        return pais1.isNotEmpty() &&
               pais2.isNotEmpty() &&
                pais3.isNotEmpty()
    }

    //Funcion para verificar que los paises no esten repetidos
    private fun noPaisesRepetidos(pais1: String, pais2: String, pais3: String): Boolean {
        return pais1.uppercase() != pais2.uppercase() &&
                pais2.uppercase() != pais3.uppercase() &&
                pais1.uppercase() != pais3.uppercase()
    }
}