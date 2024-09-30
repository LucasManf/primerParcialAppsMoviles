package com.example.primerparciallucasmanfredi

import android.content.Context;
import android.content.Intent;

class IntentHelper {
    fun doIntent(context: Context, pais1: String, pais2: String, pais3: String) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("PrimerPais", pais1)
        intent.putExtra("SegundoPais", pais2)
        intent.putExtra("TercerPais", pais3)
        context.startActivity(intent)
    }
    fun intentVolver(context: Context, destination: Class<*>) {
        val intent = Intent(context, destination)
        context.startActivity(intent)
    }
}
