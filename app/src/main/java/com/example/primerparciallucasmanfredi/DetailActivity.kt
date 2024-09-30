package com.example.primerparciallucasmanfredi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    //Declaracion de variables UI
    private lateinit var tvNombre: TextView
    private lateinit var tvPais: TextView
    private lateinit var tvDeporte: TextView
    private lateinit var tvActivo: TextView
    private lateinit var buttonVolver2: Button

    //Variable para guardar que texto se muestra dependiendo si el estado de actividad es true o false
    private lateinit var textoActivo: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Inicializacion de variables UI
        tvNombre = findViewById(R.id.tvNombre)
        tvPais = findViewById(R.id.tvPais)
        tvDeporte = findViewById(R.id.tvDeporte)
        tvActivo = findViewById(R.id.tvActivo)
        buttonVolver2 = findViewById(R.id.buttonVolver2)

        //Recuperacion de informacion del deportista seleccionado en la actividad anterior
        val bundle = intent.extras
        val id = bundle?.getInt("idDeportista", 0)
        val nombre = bundle?.getString("nombreDeportista", "")
        val deporte = bundle?.getString("deporte", "")
        val pais = bundle?.getString("pais", "")
        val activo = bundle?.getBoolean("activo", )

        //Verificacion de actividad de deportista (podria ser una funcion aparte tambien)
        if (activo == true) {
            textoActivo = "Si"
        } else {
            textoActivo = "No"
        }

        //Asignacion de texto a elementos de UI
        tvNombre.text = "Nombre: $nombre"
        tvPais.text = "Nacionalidad: $pais"
        tvDeporte.text = "Deporte: $deporte"
        tvActivo.text = "Activo: $textoActivo"

        //On click listener de boton "volver"
        buttonVolver2.setOnClickListener {
            finish()
        }
    }
}