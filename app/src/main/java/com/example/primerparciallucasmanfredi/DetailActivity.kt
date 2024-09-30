package com.example.primerparciallucasmanfredi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var tvNombre: TextView
    private lateinit var tvPais: TextView
    private lateinit var tvDeporte: TextView
    private lateinit var tvActivo: TextView
    private lateinit var buttonVolver2: Button
    private lateinit var textoActivo: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        buttonVolver2 = findViewById(R.id.buttonVolver2)

        val bundle = intent.extras
        val id = bundle?.getInt("idDeportista", 0)
        val nombre = bundle?.getString("nombreDeportista", "")
        val deporte = bundle?.getString("deporte", "")
        val pais = bundle?.getString("pais", "")
        val activo = bundle?.getBoolean("activo", )

        tvNombre = findViewById(R.id.tvNombre)
        tvPais = findViewById(R.id.tvPais)
        tvDeporte = findViewById(R.id.tvDeporte)
        tvActivo = findViewById(R.id.tvActivo)

        if (activo == true) {
            textoActivo = "Si"
        } else {
            textoActivo = "No"
        }

        tvNombre.text = "Nombre: $nombre"
        tvPais.text = "Nacionalidad: $pais"
        tvDeporte.text = "Deporte: $deporte"
        tvActivo.text = "Activo: $textoActivo"

        buttonVolver2.setOnClickListener {
            finish()
        }
    }
}